package com.azarenka.rest;

import com.azarenka.domain.Filter;
import com.azarenka.service.api.FoodService;
import com.azarenka.service.api.UserService;
import com.azarenka.service.response.FoodResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping(value = "/foods")
public class FoodController {

    @Autowired
    private FoodService foodService;

    /**
     * Receives request without parameters and returns all food.
     * Before return it convert entity {Food} to FoodResponse
     *
     * @return list of food response
     */
    @RequestMapping(method = RequestMethod.GET, value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FoodResponse> getFoods() {
        return foodService.getFoods();
    }

    /**
     * Receives request with parameter Filter. Class Filter has 3 fields which participating in searching of foods.
     * Default parameters this fields equals 0. If all parameters will equals 0 that list of FoodResponse will
     * has size 0.
     *
     * @param filter filter Filter.class
     * @return list of food response
     */
    @RequestMapping(method = RequestMethod.GET, value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FoodResponse> getAllFoodsByFilter(@RequestBody Filter filter) {
        return foodService.getFoods(filter);
    }
}
