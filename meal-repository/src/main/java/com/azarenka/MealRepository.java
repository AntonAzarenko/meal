package com.azarenka;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Meal repository.
 * <p>
 * (c) ant-azarenko@mail.ru
 * </p>
 *
 * @author Anton Azarnko
 * Date 12 08 2019
 */
@Mapper
public interface MealRepository {

    /**
     * @return list of days
     */
    List<Meal> getAll();

    /**
     * @param mealId meal id
     * @return meal by id
     */
    Meal getMealById(String mealId);
}
