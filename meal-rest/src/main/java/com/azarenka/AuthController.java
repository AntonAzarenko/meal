package com.azarenka;

import com.azarenka.api.UserService;
import com.azarenka.auth.JwtResponse;
import com.azarenka.auth.LoginForm;
import com.azarenka.auth.ResponseMessage;
import com.azarenka.auth.SignUpForm;
import com.azarenka.evaluator.UserEvaluator;
import com.azarenka.security.jwt.JwtProvider;
import com.azarenka.service.auth.RegistrationUser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

/**
 * Authentication controller
 * <p>
 * <p>
 * (c) ant-azarenko@mail.ru
 * </p>
 *
 * @author Anton Azarnka
 * @Date 21.07.2019
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("auth")
public class AuthController {

    private final static Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private UserService userService;
    @Autowired
    private UserEvaluator evaluator;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
        if (userService.existsByUserName(signUpRequest.getUsername())) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
                HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setEmail(signUpRequest.getUsername());
        user.setPassword(encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                    roles.add(Role.ROLE_ADMIN);
                    break;
                default:
                    roles.add(Role.ROLE_USER);
            }
        });

        user.setRoles(roles);
        userService.save(user);

        return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
    }

    @PreAuthorize(value = "@userEvaluator.check(#registrationUser)")
    @RequestMapping(method = RequestMethod.POST, value = "/registerUser")
    public String add(RegistrationUser registrationUser) {
        if (evaluator.check(registrationUser)) {
            userService.save(registrationUser);
        }
        return "landingPage";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping(value = "start")
    public String redirectToStartPage(Model model) {
        model.addAttribute("login", userService.getUserName());
        LOGGER.info("redirect to landing page");
        return "landingPage";
    }

    @GetMapping(value = "login")
    public String redirectToLoginPage() {
        LOGGER.info("redirect to login page");
        return "login";
    }

    @GetMapping(value = "/")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/logout")
    public String logout() {
        return "";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/activate/{code}")
    public String activate(Model model, @PathVariable("code") String code) {
        if (userService.isActivate(code)) {
            model.addAttribute("message", "Activate successfully");
        }
        model.addAttribute("message", "Error");
        return "landingPage";
    }
}
