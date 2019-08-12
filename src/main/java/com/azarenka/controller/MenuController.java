package com.azarenka.controller;

import com.azarenka.domain.Food;
import com.azarenka.response.MenuResponse;
import com.azarenka.service.api.FoodService;
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
    private FoodService foodService;

    @GetMapping(value = "to-create")
    public String getFoods(Model model) {
        List<Food> foods = foodService.getFoods();
        //List<MenuResponse> = menuService.getMenu();
        model.addAttribute("foods", foods);
        return "create_menu";
    }

    @PostMapping(value = "addMenu/")
    public String saveToMenu(@RequestParam(required = false) @PathVariable("foodId") String foodId,
                             @RequestParam(required = false) @PathVariable("day") String day,
                             @RequestParam(required = false) @PathVariable("meal") String meal,
                             @RequestParam(required = false) @PathVariable("count") int count) {
        return "redirect: /to-create";
    }

}
