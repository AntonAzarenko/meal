package com.azarenka.rest;

import com.azarenka.domain.Food;
import com.azarenka.domain.User;
import com.azarenka.service.api.FoodService;
import com.azarenka.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping(value = "/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/allfood", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Food> getFoods() {
        return foodService.getFoods();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUsers() {
        return userService.getByEmail("admin@mail.ru");
    }
}
