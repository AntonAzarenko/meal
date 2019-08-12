package com.azarenka.service.impl;

import com.azarenka.auth.LoggedUser;
import com.azarenka.auth.RegistrationUser;
import com.azarenka.domain.Role;
import com.azarenka.domain.User;
import com.azarenka.mail.Mail;
import com.azarenka.repository.UserRepository;
import com.azarenka.repository.UsersRoleMapRepository;
import com.azarenka.service.api.UserService;
import com.azarenka.util.KeyGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * User service implementation.
 * <p>
 * (c) ant-azarenko@mail.ru
 * </p>
 *
 * @author Anton Azarnka
 * Date: 21.07.2019
 */
@Service("userService")

public class UserServiceImpl implements UserService, UserDetailsService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private UserRepository repository;
    @Autowired
    private UsersRoleMapRepository roleMapRepository;
    @Autowired
    private Mail mail;
    @Value("${mail.url}")
    private String url;

    @Override
    @Transactional
    public void save(RegistrationUser registrationUser) {
        User user = new User();
        user.setId(KeyGenerator.generateUuid());
        user.setEmail(registrationUser.getLogin());
        user.setName(registrationUser.getName());
        user.setActivateCode(UUID.randomUUID().toString());
        try {
            LOGGER.info("Start creating user {}", registrationUser.getName());
            user.setPassword(encoder.encode(registrationUser.getPassword()));
            repository.save(user);
            String roleId = roleMapRepository.getIdByRole(Role.ROLE_USER.name());
            roleMapRepository.saveRole(user.getId(), roleId);
            String message = String.format("Hello %s. Please activate your account for Health Food. %s%s",
                    user.getName(), url, user.getActivateCode());
            mail.sendMessage(registrationUser.getLogin(), Mail.REGISTRATION_MASSAGE, message);
        } catch (Exception e) {
            LOGGER.info("Mail hasn't been send {} {}", registrationUser.getLogin(), e.getMessage());
        }
    }

    @Override
    public User getByEmail(String email) {
        return repository.getByEmail(email);
    }

    @Override
    public LoggedUser loadUserByUsername(String login) throws UsernameNotFoundException {
        User u = repository.getByEmail(login);
        if (u == null) {
            throw new UsernameNotFoundException("User " + login + " not found!");
        }
        return new LoggedUser(u);
    }

    @Override
    public String getUserName() {
        LoggedUser loggedUser = LoggedUser.safeGet();
        if (loggedUser != null) {
            return loggedUser.getUserNick();
        }
        return null;
    }

    @Override
    public boolean isActivate(String code) {
        LOGGER.info("isActivate....");
        User user = repository.getByActivateCode(code);
        if(null == user){
            return false;
        }
        repository.update(user.getId(), true);
        return true;
    }
}
