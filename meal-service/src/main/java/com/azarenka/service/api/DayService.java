package com.azarenka.service.api;

import com.azarenka.domain.Day;

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
