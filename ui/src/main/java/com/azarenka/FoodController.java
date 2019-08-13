package com.azarenka;

import com.azarenka.api.FoodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Food controller
 * <p>
 * (c) ant-azarenko@mail.ru
 * </p>
 *
 * @author Anton Azarnka
 * Date 21 07 2019
 */
@Controller
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping(value = "foods")
    public String getFoods(Model model) {
        List<Food> foods = foodService.getFoods();
        model.addAttribute("foods", foods);
        return "food";
    }
}
