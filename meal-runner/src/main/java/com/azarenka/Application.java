package com.azarenka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
