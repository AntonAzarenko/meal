package com.azarenka.service.impl;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import static java.util.Collections.singleton;

import com.azarenka.domain.Role;
import com.azarenka.domain.User;
import com.azarenka.domain.auth.SignUpForm;
import com.azarenka.repository.UserRepository;
import com.azarenka.repository.UsersRoleMapRepository;
import com.azarenka.service.util.KeyGenerator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RunWith(PowerMockRunner.class)
@PrepareForTest({KeyGenerator.class})
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService = new UserServiceImpl();
    @Mock
    private UserRepository repository;
    @Mock
    private BCryptPasswordEncoder encoder;
    @Mock
    private UsersRoleMapRepository roleMapRepository;

    @Test
    public void testSave() {
        mockStatic(KeyGenerator.class);
        when(KeyGenerator.generateUuid()).thenReturn("123");
        doNothing().when(repository).save(getUser());
        userService.save(getForm());
        verify(repository);
    }

    @Test
    public void testGetByEmail() {
        userService.getByEmail("asd");
        verify(repository);
    }

    @Test
    public void testIsActivate() {
        mockStatic(KeyGenerator.class);
        when(repository.getByActivateCode("123")).thenReturn(new User());
        userService.isActivate("123");
        verify(repository).getByActivateCode("123");
        verify(repository).update(null, true);
    }

    private User getUser() {
        User user = new User();
        user.setName("name");
        user.setActivateCode("123");

        return user;
    }

    public SignUpForm getForm() {
        SignUpForm form = new SignUpForm();
        form.setName("name");
        form.setPassword("password");
        form.setRole(singleton(Role.valueOf("ROLE_USER").name()));
        return form;
    }
}
