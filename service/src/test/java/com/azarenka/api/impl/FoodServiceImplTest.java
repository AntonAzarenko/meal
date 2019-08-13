package com.azarenka.api.impl;

import com.azarenka.Food;
import com.azarenka.api.FoodService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

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