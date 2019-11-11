package com.azarenka.repository;

import com.azarenka.domain.Day;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Day repository.
 * <p>
 * (c) ant-azarenko@mail.ru
 * </p>
 *
 * @author Anton Azarnko
 * Date 12 08 2019
 */
@Mapper
public interface DayRepository {

    /**
     * returns list od days
     */
    List<Day> getAll();

    /**
     * Returns day by day id
     *
     * @param dayId day id
     * @return day id
     */
    Day getDayById(String dayId);

    /**
     * Returns day by name.
     * @param name
     * @return
     */
    Day findDayByName(String name);
}
