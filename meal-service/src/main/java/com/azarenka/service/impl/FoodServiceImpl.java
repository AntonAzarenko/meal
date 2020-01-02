package com.azarenka.service.impl;

import com.azarenka.domain.Filter;
import com.azarenka.repository.FoodRepository;
import com.azarenka.service.api.FoodService;
import com.azarenka.service.response.FoodResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<FoodResponse> getFoods() {
        return foodRepository
                .findAll()
                .stream()
                .map(FoodResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodResponse> getFoods(Filter filter) {
        if (filter.getCarbohydrates() == 1
                && filter.getFats() == 1
                && filter.getProtein() == 1
                || filter.getCarbohydrates() == 0
                && filter.getFats() == 0
                && filter.getProtein() == 0) {
            return foodRepository
                    .findAll()
                    .stream()
                    .map(FoodResponse::new)
                    .collect(Collectors.toList());
        }
        return foodRepository
                .findAllByFilter(filter)
                .stream()
                .map(FoodResponse::new)
                .collect(Collectors.toList());
    }
}
