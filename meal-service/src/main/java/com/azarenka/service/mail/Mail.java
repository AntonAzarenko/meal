package com.azarenka.service.mail;

import com.azarenka.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;


public class Mail {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);


    private JavaMailSender javaMailSender = new JavaMailSenderImpl();

    private SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

    public static String REGISTRATION_MASSAGE = "Вам пришло это писмо так как вы зарегистрировались в программе HEALTH FOOD";

    public void sendMessage(String login, String title, String message) {
        LOGGER.info("Send mail to {}", login);
        simpleMailMessage.setTo(login);
        simpleMailMessage.setText(REGISTRATION_MASSAGE + message);
        javaMailSender.send(simpleMailMessage);
    }
}
