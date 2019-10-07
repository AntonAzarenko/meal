package com.azarenka.service.api;

import com.azarenka.domain.Food;

import java.util.List;

/**
 * Food service API
 * <p>
 * (c) ant-azarenko@mail.ru
 * </p>
 *
 * @author Anton Azarnko
 * Date 10.08.2019
 */
public interface FoodService {

    /**
     * Gets all food.
     */
    List<Food> getFoods();
}
