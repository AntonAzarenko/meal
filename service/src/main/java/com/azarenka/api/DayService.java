package com.azarenka.api;

import com.azarenka.Day;

import java.util.List;

/**
 * Day service API
 * <p>
 * (c) ant-azarenko@mail.ru
 * </p>
 * Date 12 08 2019
 *
 * @author Anton Azarnko
 */
public interface DayService {

    /**
     * returns list od days
     */
    List<Day> getAll();
}
