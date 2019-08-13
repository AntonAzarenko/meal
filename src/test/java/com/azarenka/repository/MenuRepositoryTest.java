package com.azarenka.repository;

import com.azarenka.domain.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration({
        "classpath:spring/spring-context.xml",
        "classpath:spring/spring-dataBase.xml",
        "classpath:spring/spring-mybatis-bean.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class MenuRepositoryTest {

    @Autowired
    private MenuRepository repository;

    @Test
    public void getMenu() {
        List<Menu> menus = Collections.singletonList(buildMenu());
        assertEquals(menus, repository.getMenu("0630d55b-a9e5-4421-beb8-15c087571db5"));
    }

    private Menu buildMenu() {
        Menu menu = new Menu();
        menu.setId("f23f9730-59ad-4954-b708-3a8857295343");
        menu.setUserId("0630d55b-a9e5-4421-beb8-15c087571db5");
        menu.setFoodId("ffa5b689-2c0c-4142-99aa-cc1563fb8ab6");
        menu.setDayId("aafd457c-bfe4-4033-8ee0-8674f4ba7d0d");
        menu.setMealId("a7d51fe2-9e6d-49cb-bd54-1b24ff1d9c08 ");
        menu.setEmail("ant-azarenko@mail.ru");
        menu.setDate(new Date(2019,8,5));
        menu.setSetTitle("test");
        return menu;
    }
}