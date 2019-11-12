package com.azarenka.service.impl;

import com.azarenka.domain.Food;
import com.azarenka.domain.Measurement;
import com.azarenka.domain.Menu;
import com.azarenka.repository.DayRepository;
import com.azarenka.repository.FoodRepository;
import com.azarenka.repository.MealRepository;
import com.azarenka.repository.MenuRepository;
import com.azarenka.service.api.MenuService;
import com.azarenka.service.impl.auth.UserPrinciple;
import com.azarenka.service.response.MenuResponse;
import com.azarenka.service.util.KeyGenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Menu service
 * <p>
 * (c) ant-azarenko@mail.ru
 * </p>
 * Date 12 08 2019
 *
 * @author Anton Azarnka
 */
@Service
public class MenuServiceImpl implements MenuService {

    private final static Logger LOGGER = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private DayRepository dayRepository;
    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private FoodRepository foodRepository;

    @Override
    public List<MenuResponse> getMenu() {
        String userId = Objects.requireNonNull(UserPrinciple.safeGet()).getId();
        List<Menu> menuList = menuRepository.getMenu(userId);
        List<MenuResponse> menuResponses = new ArrayList<>();
        if (menuList.size() > 0) {
            menuList.forEach(menu -> menuResponses.add(convertToMenuResponse(menu)));
        }
        return menuResponses.stream().sorted((e, f) -> e.compareTo(f.getMeal())).collect(Collectors.toList());
    }

    @Override
    public void save(MenuResponse menuResponse) {
        String dayId = dayRepository.findDayByName(menuResponse.getDay()).getId();
        String mealId = mealRepository.findByName(menuResponse.getMeal()).getId();
        String foodId = foodRepository.findFoodByName(menuResponse.getFood()).getId();
        createMenu(foodId, dayId, mealId, Integer.parseInt(menuResponse.getCount()),
                menuResponse.getMenuTitle());
    }

    private void createMenu(String foodId, String dayId, String mealId, int count, String title) {
        Menu menu = new Menu();
        menu.setId(KeyGenerator.generateUuid());
        menu.setFoodId(foodId);
        menu.setDayId(dayId);
        menu.setUserId(UserPrinciple.safeGet().getId());
        menu.setMealId(mealId);
        menu.setCountFood(count);
        menu.setDate(new Date());
        menu.setEmail(UserPrinciple.safeGet().getUsername());
        menu.setTitleOfSet(title);
        menuRepository.save(menu);
    }

    @Override
    public void remove(String id) {
        menuRepository.remove(id);
    }

    @Override
    public List<String> getMenuNames(List<Menu> menus) {
        return menuRepository.getMenuNames(Objects.requireNonNull(UserPrinciple.safeGet()).getId());
    }

    private MenuResponse convertToMenuResponse(Menu menu) {
        MenuResponse menuResponse = new MenuResponse();
        if (Objects.nonNull(menu)) {
            menuResponse.setId(menu.getId());
            menuResponse.setMenuTitle(menu.getTitleOfSet());
            menuResponse.setDay(dayRepository.getDayById(menu.getDayId()).getDay());
            Food food = foodRepository.findFoodById(menu.getFoodId());
            menuResponse.setFood(food.getTitle());
            menuResponse.setMeal(food.getTitle());
            menuResponse.setMeal(mealRepository.getMealById(menu.getMealId()).getMeal());
            menuResponse.setCarbohydrates(String.valueOf(
                    countPropertyOfFood(food.getCarbohydrates(), menu.getCountFood())));
            menuResponse.setFats(String.valueOf(
                    countPropertyOfFood(food.getFats(), menu.getCountFood())));
            menuResponse.setProtein(String.valueOf(
                    countPropertyOfFood(food.getProtein(), menu.getCountFood())));
            menuResponse.setCount(countFormatter(food.getWeight(), menu.getCountFood(), food.getMeasurement()));
        }
        return menuResponse;
    }

    private int countPropertyOfFood(int item, int count) {
        return item == 0 ? 0 : item * count;
    }

    private String countFormatter(double item, int count, Measurement measurement) {
        double prop = item * count;
        if (prop > 0.5) {
            prop = Math.round(prop);
        }

        return String.format("%s - %s", String.valueOf(prop), measurement);
    }
}
