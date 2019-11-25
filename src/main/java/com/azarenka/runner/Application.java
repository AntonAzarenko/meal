package com.azarenka.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main class of Spring Boot application.
 * <p>
 * Copyright (C) 2018 azarenka.com
 * <p>
 * Date: Oct 10, 2018
 *
 * @author Anton Azarenka
 */
//@EnableJms
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.azarenka.runner", "com.azarenka.rest", "com.azarenka.service",
    "com.azarenka.repository", "com.azarenka.domain"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
