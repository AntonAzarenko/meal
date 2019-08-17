package com.azarenka.controller;

import com.azarenka.domain.Food;
import com.azarenka.domain.Menu;
import com.azarenka.service.api.DayService;
import com.azarenka.service.api.FoodService;
import com.azarenka.service.api.MealService;
import com.azarenka.service.api.MenuService;
import com.azarenka.service.api.UserService;
import com.azarenka.service.response.MenuResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Menu  controller
 * <p>
 * (c) ant-azarenko@mail.ru
 * </p>
 *
 * @author Anton Azarnka
 * Date 21 07 2019
 */
@Controller
public class MenuController {

    @Autowired
    private UserService userService;
    @Autowired
    private FoodService foodService;
    @Autowired
    private DayService dayService;
    @Autowired
    private MealService mealService;
    @Autowired
    private MenuService menuService;

    private final static Logger LOGGER = LoggerFactory.getLogger(MenuController.class);

    @GetMapping(value = "/to-create")
    public String getFoods(Model model) {
        List<MenuResponse> menu = menuService.getMenu();
        model.addAttribute("menus", menu);
        model.addAttribute("foods", foodService.getFoods());
        model.addAttribute("days", dayService.getAll());
        model.addAttribute("meals", mealService.getAll());
        model.addAttribute("login", userService.getUserName());
        model.addAttribute("menu", menu.stream().map(MenuResponse::getSetTitle)
                .distinct().collect(Collectors.toList()));
        return "create_menu";
    }

    @PostMapping(value = "/addFoodToMenu")
    public String saveToMenu(@RequestParam(required = false) @PathVariable("foodId") String foodId,
                             @RequestParam(required = false) @PathVariable("dayId") String dayId,
                             @RequestParam(required = false) @PathVariable("mealId") String mealId,
                             @RequestParam(required = false) @PathVariable("count") int count,
                             @RequestParam(required = false) @PathVariable("setTitle") String setTitle) {
        menuService.createMenu(foodId, dayId, mealId, count, setTitle);
        return "redirect:/to-create";
    }

    @PostMapping(value = "/remove/{id}")
    public String remove(@PathVariable("id") String id) {
        menuService.remove(id);
        return "redirect:/to-create";
    }
}
