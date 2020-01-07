package com.azarenka.repository.testinteg;

import com.azarenka.domain.Role;
import com.azarenka.domain.User;
import com.azarenka.repository.UserRepository;
import com.azarenka.repository.UsersRoleMapRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.UUID;

import static java.util.Collections.singleton;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EmbeddedPostgresConfig.class})
public class UserRepositoryIntegrationTest {

    @Resource
    private UserRepository userRepository;
    @Resource
    private UsersRoleMapRepository roleMapRepository;

    private final static Logger LOGGER = LoggerFactory.getLogger(UserRepositoryIntegrationTest.class);

    @Test
    public void testGetUserByEmail() {
        User user = buildUser("4993f33d-cd83-4b87-a4d4-57a11e65aa9b", "Admin@mail.ru", Role.ROLE_ADMIN, "active");
        user.setRegistrationDate(LocalDateTime.of(2019, 9, 22, 0, 0, 0));
        assertEquals(user, userRepository.getByEmail("Admin@mail.ru"));
    }

    @Test
    public void testSaveUser() {
        User user = buildUser(UUID.randomUUID().toString(), "user@maill.ru", Role.ROLE_USER,
                "1993f33d-7d83-4b87-a4d4-57a11e65aa9b");
        //user.setRegistrationDate(LocalDateTime.of(2019,9,22,0,0,0));
        userRepository.save(user);
        String roleId = roleMapRepository.getIdByRole("ROLE_USER");
        roleMapRepository.saveRole(user.getId(), roleId);
        assertEquals(user, userRepository.getByEmail("user@maill.ru"));
    }

    @Test
    public void testGetByActivateCode() {
        User user = buildUser(UUID.randomUUID().toString(), "userTwo@mail.ru", Role.ROLE_USER,
                "2993f33d-cd81-4b87-a4d4-57a11e65aa9b");
        user.setRegistrationDate(LocalDateTime.of(2019, 9, 22, 0, 0, 0));
        userRepository.save(user);
        String roleId = roleMapRepository.getIdByRole("ROLE_USER");
        roleMapRepository.saveRole(user.getId(), roleId);
        assertEquals(user, userRepository.getByActivateCode("2993f33d-cd81-4b87-a4d4-57a11e65aa9b"));
    }

    public User buildUser(String id, String email, Role role, String activateCode) {
        User user = new User();
        user.setId(id);
        user.setEnabled(true);
        user.setEmail(email);
        user.setRoles(singleton(role));
        user.setActivateCode(activateCode);
        user.setName("admin");
        user.setPassword("admin");
        user.setRegistrationDate(LocalDateTime.of(2019, 9, 22, 0, 0, 0));
        user.setCurrentMenu("");
        return user;
    }
}
