package com.azarenka.service.api;

import com.azarenka.domain.Filter;
import com.azarenka.domain.Food;
import com.azarenka.service.response.FoodResponse;

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
    List<FoodResponse> getFoods();

    /**
     * Returns all food by filter.
     *
     * @param filter filter
     * @return list of food.
     */
    List<FoodResponse> getFoods(Filter filter);


}
