package com.azarenka.evaluator;

import com.azarenka.User;
import com.azarenka.api.UserRepository;
import com.azarenka.auth.RegistrationUser;

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
