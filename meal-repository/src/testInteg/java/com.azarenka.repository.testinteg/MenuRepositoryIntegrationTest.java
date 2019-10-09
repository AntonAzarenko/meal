package com.azarenka.repository.testinteg;

import com.azarenka.domain.Menu;
import com.azarenka.repository.MenuRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EmbeddedPostgresConfig.class})
public class MenuRepositoryIntegrationTest {

    private final static String USER_ID = "4993f33d-cd83-4b87-a4d4-57a11e65aa9b";
    private final static String DAY_ID = "aafd457c-bfe4-4033-8ee0-8674f4ba7d0d";
    private final static String MEAL_ID = "a7d51fe2-9e6d-49cb-bd54-1b24ff1d9c08 ";
    private final static String FOOD_ID = "a916143d-720c-488a-8179-0511c347ee9d";
    private final static String MENU_ID = "4993f33d-8ee0-49cb-bfe4-1b24ff1d9c01 ";

    @Autowired
    private MenuRepository menuRepository;

    @Before
    public void before() throws ParseException {
        Menu menu = buildMenu("89e0057a-5557-4500-a7c4-28c056cb17d2", USER_ID,
                "b272327c-f198-49c2-a45e-a84b19885852", "250425f4-5084-45e2-804f-9f1c5867ba62",
                "33a0499d-8469-4d2b-89fd-ebfe28669251", "usernumberTree@mail.ru");
        menuRepository.save(menu);
    }

    @After
    public void after() throws ParseException {
        Menu menu = buildMenu("89e0057a-5557-4500-a7c4-28c056cb17d2", USER_ID,
                "b272327c-f198-49c2-a45e-a84b19885852", "250425f4-5084-45e2-804f-9f1c5867ba62",
                "33a0499d-8469-4d2b-89fd-ebfe28669251", "usernumberTree@mail.ru");
        List<Menu> menuList = menuRepository.getMenu(USER_ID);
        if (menuList.contains(menu)) {
            menuRepository.remove("89e0057a-5557-4500-a7c4-28c056cb17d2");
        }
    }

    @Test
    public void testSave() throws ParseException {
        Menu menu = buildMenu(MENU_ID, USER_ID, DAY_ID, MEAL_ID, FOOD_ID, "User@mail.ru");
        menu.setCountFood(3);
        menuRepository.save(menu);
        List<Menu> menus = menuRepository.getMenu(USER_ID);
        menus = menus.stream().filter(e -> e.getId().equals(MENU_ID)).collect(Collectors.toList());
        assertEquals(1, menus.size());
        assertEquals(menu, menus.get(0));
        menuRepository.remove(MENU_ID);
    }

    @Test
    public void testGetByUserId() throws ParseException {
        Menu menu = buildMenu("897dadb9-aaec-4a53-9a20-606ef965761f", USER_ID, "1ceffdb1-5327-4283-8f9d-ac98ae87faf9",
                "7f19e949-2b93-48c2-a878-bc7a18ad749d", "d99c4f05-fec0-47bf-8652-cb6dca9f236e", "Admin@mail.ru");
        List<Menu> menuList = menuRepository.getMenu(USER_ID);
        assertEquals(menu, menuList.get(0));
        assertEquals(3, menuList.size());
    }

    @Test
    public void testGetNames(){
        List<Menu> menuList = menuRepository.getMenu(USER_ID);
        assertEquals(3, menuList.size());
    }

    @Test
    public void testRemove() {
        List<Menu> menuList = menuRepository.getMenu(USER_ID);
        assertEquals(3, menuList.size());
        menuRepository.remove("897dadb9-aaec-4a53-9a20-606ef965761f");
        List<Menu> secondMenuList = menuRepository.getMenu(USER_ID);
        assertEquals(2, secondMenuList.size());
    }

    private Menu buildMenu(String id, String userID, String dayId, String mealId, String foodId, String email)
            throws ParseException {
        Menu menu = new Menu();
        menu.setId(id);
        menu.setUserId(userID);
        menu.setDayId(dayId);
        menu.setMealId(mealId);
        menu.setFoodId(foodId);
        menu.setDate(new SimpleDateFormat("yyyy-MM-dd", Locale.US).parse("2019-02-01"));
        menu.setCountFood(3);
        menu.setTitle("foods");
        menu.setEmail(email);
        return menu;
    }
}
