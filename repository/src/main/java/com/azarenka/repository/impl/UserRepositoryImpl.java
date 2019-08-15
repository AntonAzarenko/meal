package com.azarenka.repository.impl;

import com.azarenka.domain.User;
import com.azarenka.repository.api.UserRepository;


public class UserRepositoryImpl implements UserRepository {
    @Override
    public void save(User user) {

    }

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public User getByActivateCode(String code) {
        return null;
    }

    @Override
    public void update(String id, boolean enabled) {

    }
}
