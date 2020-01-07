package com.azarenka.service.impl;

import com.azarenka.domain.Food;
import com.azarenka.domain.Measurement;
import com.azarenka.domain.Menu;
import com.azarenka.domain.User;
import com.azarenka.repository.*;
import com.azarenka.service.api.MenuService;
import com.azarenka.service.impl.auth.UserPrinciple;
import com.azarenka.service.response.MenuResponse;
import com.azarenka.service.response.TodayMenuResponse;
import com.azarenka.service.util.KeyGenerator;
import com.azarenka.service.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    private UserRepository userRepository;
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
    public void save(List<MenuResponse> menuResponse) {
        menuResponse.forEach(System.out::println);
        menuResponse.forEach(el -> {
            System.out.println(el.toString());
            String dayId = dayRepository.findDayByName(el.getDay()).getId();
            String mealId = mealRepository.findByName(el.getMeal()).getId();
            String foodId = foodRepository.findFoodByName(el.getFood()).getId();
            createMenu(foodId, dayId, mealId, Integer.parseInt(el.getCount()),
                    el.getMenuTitle());
        });
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
        User user = userRepository.getByEmail(UserPrinciple.safeGet().getUsername());
        user.setCurrentMenu(title);
        userRepository.update(user);
    }

    @Override
    public void remove(String id) {
        menuRepository.remove(id);
    }

    @Override
    public List<String> getMenuNames(List<Menu> menus) {
        return menuRepository.getMenuNames(Objects.requireNonNull(UserPrinciple.safeGet()).getId());
    }

    @Override
    public List<MenuResponse> getMenuByName(String title) {
        String userName = UserPrinciple.safeGet().getUsername();
        List<Menu> menuList = menuRepository.getMenuByUsernameAndMenuTitle(userName, title);
        List<MenuResponse> menuResponses = new ArrayList<>();
        if (menuList.size() > 0) {
            menuList.forEach(menu -> menuResponses.add(convertToMenuResponse(menu)));
        }
        return menuResponses.stream().sorted((e, f) -> e.compareTo(f.getDay())).collect(Collectors.toList());
    }

    @Override
    public List<MenuResponse> getMenuByName(String day, String time) {
        String currentMenu = userRepository.getByEmail(UserPrinciple.safeGet().getUsername()).getCurrentMenu();
        List<Menu> menuList = menuRepository.findMenuByFilter(UserPrinciple.safeGet().getUsername(),
                currentMenu,day, time);
        List<MenuResponse> menuResponses = new ArrayList<>();
        if (menuList.size() > 0) {
            menuList.forEach(menu -> menuResponses.add(convertToMenuResponse(menu)));
        }
        return menuResponses;
    }

    @Override
    public List<String> getMenuByUsername() {
        String userName = UserPrinciple.safeGet().getUsername();
        return menuRepository.findMenuByUserName(userName);
    }

    @Override
    public List<TodayMenuResponse> getCurrentMenu() {
        LocalDate date = LocalDate.now();
        String dayId = dayRepository.findDayByName(TimeUtil.dayToString(date.getDayOfWeek())).getId();
        String currentMenu = userRepository.getByEmail(UserPrinciple.safeGet().getUsername()).getCurrentMenu();
        List<Menu> menuList =
                menuRepository.getMenuByUsernameAndMenuTitleAndDay(UserPrinciple.safeGet().getUsername(), currentMenu, dayId);
        List<MenuResponse> filter = new ArrayList<>();
        if (menuList.size() > 0) {
            menuList.forEach(menu -> filter.add(convertToMenuResponse(menu)));
        }
        List<TodayMenuResponse> todayMenuResponses = new ArrayList<>();
        todayMenuResponses.add(new TodayMenuResponse("Завтрак", filterByTime("Breakfast", filter)));
        todayMenuResponses.add(new TodayMenuResponse("Обед", filterByTime("Lunch", filter)));
        todayMenuResponses.add(new TodayMenuResponse("Полдник", filterByTime("Second_Lunch", filter)));
        todayMenuResponses.add(new TodayMenuResponse("Ужин", filterByTime("Dinner", filter)));
        return todayMenuResponses;
    }

    @Override
    public String getTitleOfCurrentMenu() {
        return userRepository.getByEmail(UserPrinciple.safeGet().getUsername()).getCurrentMenu();
    }

    private List<MenuResponse> filterByTime(String time, List<MenuResponse> menus) {
        return menus.stream()
                .filter(e -> e.getMeal().equals(time))
                .collect(Collectors.toList());
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
            // prop = Math.round(prop);
        }

        return String.format("%s - %s", String.valueOf(prop), getDescriptions(measurement));
    }

    private String getDescriptions(Measurement measurement) {
        switch (measurement) {
            case GR:
                return "граммов";
            case DOSE:
                return "порций";
            case GLASS:
                return "стаканов";
            case THINGS:
                return "штук";
            case TEA_SPOON:
                return "чайных ложек";
        }
        return "неизвестный тип";
    }
}
