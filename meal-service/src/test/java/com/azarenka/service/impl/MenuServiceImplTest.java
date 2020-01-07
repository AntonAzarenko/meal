package com.azarenka.service.impl;

import com.azarenka.domain.*;
import com.azarenka.repository.*;
import com.azarenka.service.impl.auth.UserPrinciple;
import com.azarenka.service.response.MenuResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserPrinciple.class})
public class MenuServiceImplTest {

    @InjectMocks
    private MenuServiceImpl menuService = new MenuServiceImpl();
    @Mock
    private MenuRepository repository;
    @Mock
    private UserPrinciple userPrinciple;
    @Mock
    private DayRepository dayRepository;
    @Mock
    private MealRepository mealRepository;
    @Mock
    private FoodRepository foodRepository;
    @Mock
    private UserRepository userRepository;

    @Test
    public void testGetMenu() {
        mockStatic(UserPrinciple.class);
        when(UserPrinciple.safeGet()).thenReturn(userPrinciple);
        when(userPrinciple.getId()).thenReturn("new menu");
        when(repository.getMenu("new menu")).thenReturn(Collections.emptyList());
        menuService.getMenu();
        verify(repository).getMenu("new menu");
    }

    @Test
    public void testSave() {
        mockStatic(UserPrinciple.class);
        when(dayRepository.findDayByName("Monday")).thenReturn(buildDay());
        when(mealRepository.findByName("Breakfast")).thenReturn(buildMeal());
        when(foodRepository.findFoodByName("Мандарин")).thenReturn(buildFood());
        when(UserPrinciple.safeGet()).thenReturn(userPrinciple);
        when(userPrinciple.getId()).thenReturn("user id");
        when(userPrinciple.getUsername()).thenReturn("username");
        doNothing().when(repository).save(any(Menu.class));
        when(userRepository.getByEmail("username")).thenReturn(new User());
        menuService.save(Collections.singletonList(buildMenuResponse()));
        verify(dayRepository).findDayByName("Monday");
        verify(mealRepository).findByName("Breakfast");
        verify(foodRepository).findFoodByName("Мандарин");
        verify(repository);
    }

    @Test
    public void testGetMenuByName() {
        mockStatic(UserPrinciple.class);
        when(UserPrinciple.safeGet()).thenReturn(userPrinciple);
        when(userPrinciple.getUsername()).thenReturn("username");
        when(repository.getMenuByUsernameAndMenuTitle("username", "food")).thenReturn(Collections.emptyList());
        menuService.getMenuByName("food");
        verify(repository);
    }

    @Test
    public void testGetMenuByUsername() {
        mockStatic(UserPrinciple.class);
        when(UserPrinciple.safeGet()).thenReturn(userPrinciple);
        when(userPrinciple.getUsername()).thenReturn("username");
        when(repository.findMenuByUserName("username")).thenReturn(Collections.emptyList());
        menuService.getMenuByUsername();
        verify(repository);
    }

    private MenuResponse buildMenuResponse() {
        MenuResponse menuResponse = new MenuResponse();
        menuResponse.setMeal("Breakfast");
        menuResponse.setDay("Monday");
        menuResponse.setFood("Мандарин");
        menuResponse.setCount("3");
        return menuResponse;
    }

    private Day buildDay() {
        Day day = new Day();
        day.setDay("Monday");
        day.setId("89b442ae-0106-4109-9599-15945aaaa1de");
        return day;
    }

    private Food buildFood() {
        Food food = new Food();
        food.setTitle("Мандарин");
        food.setId("0270bd5b-8661-4b27-bb6a-617f67dadae4");
        return food;
    }

    private Meal buildMeal() {
        Meal meal = new Meal();
        meal.setMeal("Breakfast");
        meal.setId("0270bd5b-8661-4b27-bb6a-617f67dadae4");
        return meal;
    }


    @Test
    public void remove() {
    }

    @Test
    public void getMenuNames() {
    }

    @Test
    public void getMenuByName() {
    }

    @Test
    public void getMenuByUsername() {
    }
}
