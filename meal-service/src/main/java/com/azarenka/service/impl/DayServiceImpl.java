package com.azarenka.service.impl;

import com.azarenka.domain.Day;
import com.azarenka.repository.DayRepository;
import com.azarenka.service.api.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Day service
 * <p>
 * (c) ant-azarenko@mail.ru
 * </p>
 * Date 12 08 2019
 *
 * @author Anton Azarnka
 */
@Service
public class DayServiceImpl implements DayService {

    @Autowired
    private DayRepository dayRepository;

    @Override
    public List<Day> getAll() {
        return dayRepository.getAll();
    }

    @Override
    public Day getDayByName(String name) {
        return dayRepository.findDayByName(name);
    }
}
