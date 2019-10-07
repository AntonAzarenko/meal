package com.azarenka.service.impl;

import com.azarenka.domain.Meal;
import com.azarenka.repository.MealRepository;
import com.azarenka.service.api.MealService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Meal service
 * <p>
 * (c) ant-azarenko@mail.ru
 * </p>
 * Date 12 08 2019
 *
 * @author Anton Azarnka
 */
@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealRepository mealRepository;

    @Override
    public List<Meal> getAll() {
        return mealRepository.getAll();
    }
}
