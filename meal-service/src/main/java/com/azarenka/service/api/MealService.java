package com.azarenka.service.api;

import com.azarenka.domain.Meal;

import java.util.List;

/**
 * Meal service API
 * <p>
 * (c) ant-azarenko@mail.ru
 * </p>
 * Date 12 08 2019
 *
 * @author Anton Azarnko
 */
public interface MealService {

    /**
     * @return list of days
     */
    List<Meal> getAll();
}
