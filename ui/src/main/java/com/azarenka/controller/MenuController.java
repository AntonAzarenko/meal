package com.azarenka.controller;

import com.azarenka.domain.Food;
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

import java.util.List;

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
        //List<MenuResponse> = menuService.getMenu();
        model.addAttribute("menus", menuService.getMenu());
        model.addAttribute("foods", foodService.getFoods());
        model.addAttribute("days", dayService.getAll());
        model.addAttribute("meals", mealService.getAll());
        model.addAttribute("login", userService.getUserName());
        return "create_menu";
    }

    @PostMapping(value = "/addMenu")
    public String saveToMenu(@RequestParam(required = false) @PathVariable("foodId") String foodId,
                             @RequestParam(required = false) @PathVariable("dayId") String dayId,
                             @RequestParam(required = false) @PathVariable("mealId") String mealId,
                             @RequestParam(required = false) @PathVariable("count") int count,
                             @RequestParam(required = false) @PathVariable("setTitle") String setTitle) {
        LOGGER.info(foodId);
        LOGGER.info(dayId);
        LOGGER.info(mealId);
        LOGGER.info(String.valueOf(count));
        LOGGER.info(setTitle);
        menuService.createMenu(foodId, dayId, mealId, count, setTitle);
        return "redirect:/to-create";
    }

}
