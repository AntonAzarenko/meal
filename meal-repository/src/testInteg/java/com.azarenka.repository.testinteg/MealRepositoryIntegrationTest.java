package com.azarenka.repository.testinteg;

import com.azarenka.domain.Meal;
import com.azarenka.repository.MealRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EmbeddedPostgresConfig.class})
public class MealRepositoryIntegrationTest {

    @Resource
    private MealRepository mealRepository;

    @Test
    public void testGetAll(){
        List<Meal> meals = mealRepository.getAll();
        assertNotNull(meals);
        assertEquals(4, meals.size());
    }

    @Test
    public void testGetById(){
        Meal meal = new Meal();
        meal.setId("a7d51fe2-9e6d-49cb-bd54-1b24ff1d9c08 ");
        meal.setMeal("Breakfast");
        assertEquals(meal, mealRepository.getMealById("a7d51fe2-9e6d-49cb-bd54-1b24ff1d9c08 "));
    }
}
