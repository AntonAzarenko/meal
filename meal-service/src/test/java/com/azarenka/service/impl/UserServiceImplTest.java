package com.azarenka.service.impl;

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

import java.time.LocalDateTime;

import static java.util.Collections.singleton;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

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
        when(encoder.encode("password")).thenReturn("password");
        doNothing().when(repository).save(getUser());
        when(roleMapRepository.getIdByRole(Role.ROLE_USER.name())).thenReturn("user_id");
        doNothing().when(roleMapRepository).saveRole("123", "user_id");
        userService.save(getForm());
        //verify(repository).save(getUser());
        verify(roleMapRepository).getIdByRole(Role.ROLE_USER.name());
        verify(roleMapRepository).saveRole("123", "user_id");
    }

    @Test
    public void testGetByEmail() {
        when(repository.getByEmail("asd")).thenReturn(new User());
        userService.getByEmail("asd");
        verify(repository);
    }

    @Test
    public void testIsActivate() {
        mockStatic(KeyGenerator.class);
        when(repository.getByActivateCode("123")).thenReturn(new User());
        userService.activating("123");
        verify(repository).getByActivateCode("123");
        verify(repository).update(null, true);
    }

    private User getUser() {
        User user = new User();
        user.setName("name");
        user.setId("123");
        user.setRegistrationDate(LocalDateTime.of(2019, 12, 30, 0, 0, 0, 0));
        user.setActivateCode("123");
        user.setPassword("password");

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
