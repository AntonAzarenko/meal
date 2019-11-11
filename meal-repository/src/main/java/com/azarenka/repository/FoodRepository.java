package com.azarenka.repository;

import com.azarenka.domain.Food;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Food repository.
 * <p>
 * (c) ant-azarenko@mail.ru
 * </p>
 *
 * @author Anton Azarnko
 * Date 10 08 2019
 */
@Mapper
public interface FoodRepository {

    /**
     * @return all foods.
     */
    List<Food> findAll();

    /**
     * @param foodId food id
     * @return food by id
     */
    Food findFoodById(String foodId);

    /**
     *
     * @param foodName food name
     * @return name of food
     */
    Food findFoodByName(@Param("foodName") String foodName);
}
