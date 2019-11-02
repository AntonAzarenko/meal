package com.azarenka.service.evaluator;

import com.azarenka.domain.User;
import com.azarenka.domain.auth.SignUpForm;
import com.azarenka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;

@Component("userEvaluator")
public class UserEvaluator {

    @Autowired
    private UserRepository repository;

    public UserEvaluator() {
    }

    public boolean check(SignUpForm registrationUser) throws AuthenticationException {
        User user = repository.getByEmail(registrationUser.getUsername());
        if (null == user) {
            return true;
        }

        throw new AuthenticationException("User already exist");
    }
}
