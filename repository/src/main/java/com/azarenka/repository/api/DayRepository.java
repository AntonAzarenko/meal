package com.azarenka.repository.api;

import com.azarenka.domain.Day;
import com.azarenka.domain.Food;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.annotation.Resource;

/**
 * Day repository.
 * <p>
 * (c) ant-azarenko@mail.ru
 * </p>
 *
 * @author Anton Azarnko
 * Date 12 08 2019
 */
@Repository
public interface DayRepository {

    /**
     * returns list od days
     */
    List<Day> getAll();

    /**
     * Returns day by day id
     * @param dayId day id
     * @return day id
     */
    Day getDayById(String dayId);
}
