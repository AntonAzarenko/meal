package com.azarenka.controller;

import com.azarenka.auth.RegistrationUser;
import com.azarenka.evaluator.UserEvaluator;
import com.azarenka.service.api.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
@Controller
public class AuthController {

    private final static Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private UserEvaluator evaluator;

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
