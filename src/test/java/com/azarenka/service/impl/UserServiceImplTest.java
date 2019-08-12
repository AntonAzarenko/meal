package com.azarenka.service.impl;

import com.azarenka.auth.RegistrationUser;
import com.azarenka.domain.Role;
import com.azarenka.domain.User;
import com.azarenka.service.api.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;


@ContextConfiguration({
        "classpath:spring/spring-context.xml",
        "classpath:spring/spring-dataBase.xml",
})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImplTest.class);

    @Resource
    private UserService service;

    @Test
    public void testSave() {
        service.save(buildRegUser());
        User expectedUser = convertRegUSerToUser(buildRegUser());
        assertEquals(expectedUser, service.getByEmail("anton_azarenka@email.ru"));
        log.info(buildUser().toString());
    }

    @Test
    public void testGetUserByEmail() {
        User user = service.getByEmail("anton_azarenka@email.ru");
        User expectedUser = buildUser();
        assertEquals(expectedUser, user);
    }

    private User buildUser() {
        Set<Role> roles = new HashSet<>();
        roles.add(Role.ROLE_ADMIN);
        User user = new User();
        user.setId("4993f33d-cd83-4b87-a4d4-57a11e65aa9b");
        user.setEmail("admin@mail.ru");
        user.setName("admin");
        user.setRoles(roles);
        user.setPassword("admin");
        return user;
    }

    private RegistrationUser buildRegUser() {
        RegistrationUser user = new RegistrationUser();
        user.setLogin("anton_azarenka@email.ru");
        user.setName("Anton");
        user.setPassword("root");
        return user;
    }

    private User convertRegUSerToUser(RegistrationUser registrationUser){
        Set<Role> roles = new HashSet<>();
        roles.add(Role.ROLE_USER);
        User user = new User();
        user.setEmail("anton_azarenka@email.ru");
        user.setName("Anton");
        user.setPassword("root");
        user.setRoles(roles);
        return user;
    }
}