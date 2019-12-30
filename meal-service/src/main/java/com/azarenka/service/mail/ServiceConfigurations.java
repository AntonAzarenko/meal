package com.azarenka.service.mail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class ServiceConfigurations {

    public static final String BASE_PACKAGE_PATH = "/templates";

    @Value("${mail.username}")
    private String username;
    @Value("${mail.password}")
    private String password;
    @Value("${mail.port}")
    private int port;
    @Value("${mail.host}")
    private String host;
    @Value("${mail.protocol}")
    private String protocol;
    @Value("${mail.smtps.auth}")
    private String smtp;

    @Bean
    public JavaMailSenderImpl getMailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(host);
        javaMailSender.setUsername(username);
        javaMailSender.setPassword(password);
        javaMailSender.setPort(port);
        javaMailSender.setProtocol(protocol);
        Properties properties = new Properties();
        properties.setProperty("mail.smtps.auth", smtp);
        javaMailSender.setJavaMailProperties(properties);
        return javaMailSender;
    }
}
