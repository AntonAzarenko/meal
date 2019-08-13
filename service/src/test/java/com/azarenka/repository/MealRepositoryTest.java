package com.azarenka.repository;

import com.azarenka.Meal;
import com.azarenka.api.MealRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration({
        "classpath:spring/spring-context.xml",
        "classpath:spring/spring-dataBase.xml",
        "classpath:spring/spring-mybatis-bean.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class MealRepositoryTest {

    @Autowired
    private MealRepository mealRepository;

    @Test
    public void getAll() {
        List<Meal> meals = Arrays.asList(
                buildMeal("a7d51fe2-9e6d-49cb-bd54-1b24ff1d9c08 ", "Breakfast"),
                buildMeal("7f19e949-2b93-48c2-a878-bc7a18ad749d", "Lunch"),
                buildMeal("250425f4-5084-45e2-804f-9f1c5867ba62", "Second_Lunch"),
                buildMeal("03bfbdb6-b62a-401b-b9ce-f1bdb4e05879", "Dinner")
        );
        assertEquals(meals, mealRepository.getAll());
    }

    private Meal buildMeal(String id, String fmeal) {
        Meal meal = new Meal();
        meal.setId(id);
        meal.setMeal(fmeal);
        return meal;
    }
}