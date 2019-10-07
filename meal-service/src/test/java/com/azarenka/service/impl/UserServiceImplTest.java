package com.azarenka.service.impl;

import com.azarenka.repository.UserRepository;
import com.azarenka.service.api.UserService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class UserServiceImplTest {

    @Mock
    private UserRepository repository;
    @InjectMocks
    private UserService userService;

    @Test
    public void testSave() {
    }

    @Test
    void getByEmail() {
    }

    @Test
    void getUserName() {
    }

    @Test
    void isActivate() {
    }
}
