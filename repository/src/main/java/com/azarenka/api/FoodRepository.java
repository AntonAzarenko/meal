package com.azarenka.api;

import com.azarenka.Food;

import org.springframework.stereotype.Repository;

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
@Repository
public interface FoodRepository {

    /**
     * @return all foods.
     */
    List<Food> getAll();
}
