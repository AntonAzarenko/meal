package com.azarenka.api;

import com.azarenka.Day;

import org.springframework.stereotype.Repository;

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
@Repository
public interface DayRepository {

    /**
     * returns list od days
     */
    List<Day> getAll();
}
