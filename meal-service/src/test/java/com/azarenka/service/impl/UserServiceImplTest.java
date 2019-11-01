package com.azarenka.service.impl;

import com.azarenka.domain.Role;
import com.azarenka.domain.User;
import com.azarenka.domain.auth.SignUpForm;
import com.azarenka.repository.UserRepository;
import com.azarenka.repository.UsersRoleMapRepository;
import com.azarenka.service.api.UserService;
import com.azarenka.service.util.KeyGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static java.util.Collections.singleton;
import static org.mockito.Mockito.*;


@RunWith(PowerMockRunner.class)
@PrepareForTest(KeyGenerator.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserService userService = new UserServiceImpl();
    @Mock
    private UserRepository repository;
    @Mock
    private BCryptPasswordEncoder encoder;
    @Mock
    private UsersRoleMapRepository roleMapRepository;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setId("123");
        user.setName("name");
        user.setPassword("password");
        user.setRoles(singleton(Role.valueOf("ROLE_USER")));
        user.setActivateCode("333");
        when(encoder.encode(anyString())).thenReturn("123");
        when(roleMapRepository.getIdByRole(anyString())).thenReturn("ROLE_USER");
        when(KeyGenerator.generateUuid()).thenReturn("335");
        userService.save(getForm());
        verify(repository).save(user);
    }

    @Test
    public void getByEmail() {
        userService.getByEmail("asd");
        verify(repository).getByEmail("asd");
    }

    @Test
    public void getUserName() {
        when(userService.getByEmail("asd")).thenReturn(new User());
        userService.getUserName();
        verify(repository);
    }

    @Test
    public void isActivate() {
        when(repository.getByActivateCode("123")).thenReturn(new User());
        doNothing().when(repository).update("id", true);
        userService.isActivate("123");
        verify(repository).getByActivateCode("123");
        verify(repository).update("id", true);

    }

    public SignUpForm getForm() {
        SignUpForm form = new SignUpForm();
        form.setName("name");
        form.setPassword("password");
        form.setRole(singleton(Role.valueOf("ROLE_USER").name()));
        return form;
    }
}
