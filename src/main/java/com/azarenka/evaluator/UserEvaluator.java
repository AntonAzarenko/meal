package com.azarenka.evaluator;

import com.azarenka.auth.RegistrationUser;
import com.azarenka.domain.User;
import com.azarenka.repository.UserRepository;
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
