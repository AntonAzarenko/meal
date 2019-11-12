package com.azarenka.service.impl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static java.util.Collections.singleton;

import com.azarenka.domain.Role;
import com.azarenka.domain.User;
import com.azarenka.domain.auth.SignUpForm;
import com.azarenka.repository.UserRepository;
import com.azarenka.repository.UsersRoleMapRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserRepository repository;
    @Mock
    private BCryptPasswordEncoder encoder;
    @Mock
    private UsersRoleMapRepository roleMapRepository;

    @Test
    public void testSave() {
        //todo {aazarenka} write test
    }

    @Test
    public void testGetByEmail() {
        userService.getByEmail("asd");
        verify(repository).getByEmail("asd");
    }

    @Test
    public void testIsActivate() {
        when(repository.getByActivateCode("123")).thenReturn(new User());
        userService.isActivate("123");
        verify(repository).getByActivateCode("123");
        verify(repository).update(null, true);
    }

    public SignUpForm getForm() {
        SignUpForm form = new SignUpForm();
        form.setName("name");
        form.setPassword("password");
        form.setRole(singleton(Role.valueOf("ROLE_USER").name()));
        return form;
    }
}
