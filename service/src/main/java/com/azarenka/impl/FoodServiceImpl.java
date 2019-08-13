package com.azarenka.impl;

import com.azarenka.domain.Food;
import com.azarenka.repository.FoodRepository;
import com.azarenka.api.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Food service
 * <p>
 * (c) ant-azarenko@mail.ru
 * </p>
 * Date 12 08 2019
 *
 * @author Anton Azarnka
 */
@Service
public class FoodServiceImpl implements FoodService{

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public List<Food> getFoods() {
        return foodRepository.getAll();
    }
}
