package com.azarenka.repository.testinteg;

import com.azarenka.domain.Menu;
import com.azarenka.repository.MenuRepository;
import com.azarenka.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EmbeddedPostgresConfig.class})
public class ManuRepositoryIntegrationTest {

    private final static String USER_ID = "4993f33d-cd83-4b87-a4d4-57a11e65aa9b";
    private final static String DAY_ID = "aafd457c-bfe4-4033-8ee0-8674f4ba7d0d";
    private final static String MEAL_ID = "a7d51fe2-9e6d-49cb-bd54-1b24ff1d9c08 ";
    private final static String FOOD_ID = "a916143d-720c-488a-8179-0511c347ee9d";
    private final static String MENU_ID = "4993f33d-8ee0-49cb-bfe4-1b24ff1d9c01 ";

    @Autowired
    private MenuRepository menuRepository;

    @Test
    public void testSave() {
        Menu menu = buildMenu();
        menuRepository.save(menu);
        List<Menu> menus = menuRepository.getMenu(USER_ID);
        assertEquals(1, menus.size());
        assertEquals(menu, menus.get(0));
    }

    private Menu buildMenu() {
        Menu menu = new Menu();
        menu.setId(MENU_ID);
        menu.setUserId(USER_ID);
        menu.setDayId(DAY_ID);
        menu.setMealId(MEAL_ID);
        menu.setFoodId(FOOD_ID);
        menu.setCountFood(3);
        menu.setDate(new Date());
        menu.setTitle("My menu");
        menu.setEmail("Admin@mail.ru");
        return menu;
    }
}
