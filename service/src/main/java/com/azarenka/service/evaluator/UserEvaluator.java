package com.azarenka.service.evaluator;

import com.azarenka.domain.User;
import com.azarenka.repository.api.UserRepository;
import com.azarenka.service.auth.RegistrationUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userEvaluator")
public class UserEvaluator {

    @Autowired
    private UserRepository repository;

    public boolean check(RegistrationUser registrationUser){
        User user = repository.getByEmail(registrationUser.getLogin());
        if( null == user){
             return true;
        }
        return false;
    }
}
