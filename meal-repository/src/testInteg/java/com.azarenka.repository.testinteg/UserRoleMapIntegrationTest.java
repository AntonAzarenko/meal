package com.azarenka.repository.testinteg;

import static org.junit.Assert.assertEquals;

import com.azarenka.domain.Role;
import com.azarenka.domain.User;
import com.azarenka.repository.UserRepository;
import com.azarenka.repository.UsersRoleMapRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EmbeddedPostgresConfig.class})
public class UserRoleMapIntegrationTest {

    @Autowired
    private UsersRoleMapRepository roleMapRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveRoleMap() throws ParseException {
        User user = buildUser(UUID.randomUUID().toString(), "userOne@mail.ru", Role.ROLE_USER,
                "2993f33d-cd83-4b87-a4d4-57a11e65aa1b");
        userRepository.save(user);
        String roleId = roleMapRepository.getIdByRole("ROLE_USER");
        roleMapRepository.saveRole(user.getId(), roleId);

        assertEquals(Collections.singleton(Role.ROLE_USER), userRepository.getByActivateCode("2993f33d-cd83-4b87-a4d4-57a11e65aa1b").getRoles());
    }

    @Test
    public void testGetIdByRole() {
        assertEquals("93d45507-5bdf-41de-af4c-0643858008d9", roleMapRepository.getIdByRole("ROLE_USER"));
        assertEquals("3e7e4373-2caa-4202-af8f-94f233a99027", roleMapRepository.getIdByRole("ROLE_ADMIN"));
    }

    private User buildUser(String id, String email, Role role, String activateCode) throws ParseException {
        User user = new User();
        user.setId(id);
        user.setEnabled(true);
        user.setName("admin");
        user.setPassword("admin");
        user.setRegistrationDate(LocalDateTime.of(2019,9,22,0,0,0));
        user.setEmail(email);
        user.setRoles(Collections.singleton(role));
        user.setActivateCode(activateCode);
        return user;
    }
}
