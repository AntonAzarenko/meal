package com.azarenka;

import com.azarenka.api.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "food/")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping(value = "allfoods")
    public List<Food> getFoods() {
        return foodService.getFoods();
    }
}
