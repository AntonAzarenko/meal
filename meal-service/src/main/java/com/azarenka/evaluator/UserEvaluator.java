package com.azarenka.evaluator;

import com.azarenka.User;
import com.azarenka.UserRepository;
import com.azarenka.auth.SignUpForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userEvaluator")
public class UserEvaluator {

    @Autowired
    private UserRepository repository;

    public boolean check(SignUpForm registrationUser){
        User user = repository.getByEmail(registrationUser.getUsername());
        if( null == user){
             return true;
        }
        return false;
    }
}
