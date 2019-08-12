package com.azarenka.service.impl;

import com.azarenka.domain.Food;
import com.azarenka.service.api.FoodService;
import com.azarenka.service.api.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration({
        "classpath:spring/spring-context.xml",
        "classpath:spring/spring-dataBase.xml",
})
@RunWith(SpringJUnit4ClassRunner.class)
public class FoodServiceImplTest {

    @Autowired
    private FoodService service;

    @Test
    public void getFoods() {
        List<Food> foods = service.getFoods();
        assertEquals(43, foods.size());
    }
}