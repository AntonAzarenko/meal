package com.azarenka.service.impl;

import com.azarenka.domain.Food;
import com.azarenka.repository.FoodRepository;
import com.azarenka.service.api.FoodService;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

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
public class FoodServiceImpl implements FoodService {

    @Resource
    private FoodRepository foodRepository;

    @Override
    public List<Food> getFoods() {
        return foodRepository.getAll();
    }
}
