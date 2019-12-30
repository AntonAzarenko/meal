
package com.azarenka.service.impl;

import com.azarenka.domain.Role;
import com.azarenka.domain.User;
import com.azarenka.domain.auth.SignUpForm;
import com.azarenka.repository.UserRepository;
import com.azarenka.repository.UsersRoleMapRepository;
import com.azarenka.service.api.UserService;
import com.azarenka.service.mail.Mail;
import com.azarenka.service.mail.MailType;
import com.azarenka.service.mail.SendMessage;
import com.azarenka.service.util.KeyGenerator;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * User service implementation.
 * <p>
 * (c) ant-azarenko@mail.ru
 * </p>
 *
 * @author Anton Azarnka
 * Date: 21.07.2019
 */
@Service
public class UserServiceImpl implements UserService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final String MAIL_SUBJECT = "activate code";

    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private UserRepository repository;
    @Autowired
    private UsersRoleMapRepository roleMapRepository;
    @Autowired
    private Mail mail;
    @Value("${mail.url}")
    private String CONFIRM_USER_CODE;

    @Override
    @Transactional
    public void save(SignUpForm registrationUser) {
        User user = buildUser(registrationUser);
        try {
            LOGGER.info("Start creating user {}", registrationUser.getName());
            user.setPassword(encoder.encode(registrationUser.getPassword()));
            repository.save(user);
            String roleId = roleMapRepository.getIdByRole(Role.ROLE_USER.name());
            roleMapRepository.saveRole(user.getId(), roleId);
            String message = String.format("Привет %s. Вам нушно пройти по ссылке ниже что-бы активировать аккаунт." +
                            "В противном случае через 3 дня он будет удален.: \n %s%s",
                    user.getName(), CONFIRM_USER_CODE, user.getActivateCode());
           sendMessage(CONFIRM_USER_CODE, user.getEmail(), user.getActivateCode());
        } catch (Exception e) {
            LOGGER.info("Mail hasn't been send {} {}", registrationUser.getUsername(), e.getMessage());
        }
    }

    @Override
    public User getByEmail(String email) {
        return repository.getByEmail(email);
    }

    @Override
    public boolean activating(String code) {
        LOGGER.info("activating....");
        User user = repository.getByActivateCode(code);
        if (null == user) {
            return false;
        }
        repository.update(user.getId(), true);
        return true;
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    protected User buildUser(SignUpForm registrationUser) {
        User user = new User();
        user.setId(KeyGenerator.generateUuid());
        user.setEmail(registrationUser.getUsername());
        user.setName(registrationUser.getName());
        user.setActivateCode(KeyGenerator.generateUuid());
        return user;
    }

    private void sendMessage(String uri, String login, String code) {
        SendMessage sendMessage = new SendMessage(login, MailType.REGISTER_CONFIRMATION,
                buildMessageData(uri, login, code));
        mail.sendMessage(sendMessage);
    }

    private static Map<String, String> buildMessageData(String uri, String login, String code) {
        Map<String, String> data = new HashMap<>();
        int endIndex = StringUtils.ordinalIndexOf(uri, "/", 3);
        data.put("uri", endIndex < 0 ? uri : uri.substring(0, endIndex));
        data.put("link", String.format(uri + code));
        return data;
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("admin123"));
    }
}
