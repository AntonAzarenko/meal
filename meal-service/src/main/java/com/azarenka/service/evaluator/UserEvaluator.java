package com.azarenka.service.evaluator;

import com.azarenka.domain.User;
import com.azarenka.domain.auth.LoginForm;
import com.azarenka.domain.auth.SignUpForm;
import com.azarenka.repository.UserRepository;
import com.azarenka.service.exeptions.AuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userEvaluator")
public class UserEvaluator {

    @Autowired
    private UserRepository repository;

    public UserEvaluator() {
    }

    public boolean check(SignUpForm registrationUser) {
        User user = repository.getByEmail(registrationUser.getUsername());
        if (null == user) {
            return true;
        }
        return false;
    }

    public boolean checkActivate(LoginForm loginForm){
        User user = repository.getByEmail(loginForm.getUsername());
        if(user.getActivateCode().equals("ACTIVATED")){
            return true;
        }
        throw  new AuthException(String.format("Пользователь %s не прошел активацию.", user.getEmail()));
    }
}
