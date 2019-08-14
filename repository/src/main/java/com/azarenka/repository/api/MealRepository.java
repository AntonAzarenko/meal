package com.azarenka.repository.api;

import com.azarenka.domain.Meal;

import org.springframework.stereotype.Repository;

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
@Repository
public interface MealRepository {

    /**
     * @return list of days
     */
    List<Meal> getAll();
}
