package com.azarenka.rest;

import com.azarenka.service.api.*;
import com.azarenka.service.response.MenuResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
