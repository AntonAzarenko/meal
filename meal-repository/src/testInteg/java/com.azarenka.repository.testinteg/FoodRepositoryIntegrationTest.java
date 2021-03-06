package com.azarenka.repository.testinteg;

import com.azarenka.domain.Filter;
import com.azarenka.domain.Food;
import com.azarenka.domain.Measurement;
import com.azarenka.repository.FoodRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EmbeddedPostgresConfig.class})
public class FoodRepositoryIntegrationTest {

    @Autowired
    private FoodRepository foodRepository;

    @Test
    public void testGetAllByFilter() {
        Filter filter = buildFilter(0, 1, 0);
        List<Food> foodList = foodRepository.findAllByFilter(filter);
        foodList.forEach(System.out::println);
        assertEquals(4, foodList.size());
        filter = buildFilter(1, 0, 0);
        foodList = foodRepository.findAllByFilter(filter);
        foodList.forEach(System.out::println);
        assertEquals(3, foodList.size());
        filter = buildFilter(0, 0, 1);
        foodList = foodRepository.findAllByFilter(filter);
        foodList.forEach(System.out::println);
        assertEquals(3, foodList.size());
    }

    @Test
    public void testGetAll() {
        List<Food> foodList = foodRepository.findAll();
        assertNotNull(foodList);
        assertEquals(10, foodList.size());
    }

    @Test
    public void testGetById() {
        Food food = foodRepository.findFoodById("a916143d-720c-488a-8179-0511c347ee9d");
        assertEquals(buildFood("a916143d-720c-488a-8179-0511c347ee9d"), food);
    }

    @Test
    public void testGetByName() {
        Food food = foodRepository.findFoodByName("Мандарин");
        assertEquals(buildFood("a916143d-720c-488a-8179-0511c347ee9d"), food);
    }

    public Food buildFood(String id) {
        Food food = new Food();
        food.setId(id);
        food.setCalories(0);
        food.setCarbohydrates(1);
        food.setFats(0);
        food.setProtein(0);
        food.setTitle("Мандарин");
        food.setWeight(1);
        food.setMeasurement(Measurement.THINGS);
        return food;
    }

    private Filter buildFilter(int fats, int carbohydrates, int protein) {
        Filter filter = new Filter();
        filter.setCarbohydrates(carbohydrates);
        filter.setProtein(protein);
        filter.setFats(fats);
        return filter;
    }
}
