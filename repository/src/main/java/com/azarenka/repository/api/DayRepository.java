package com.azarenka.repository.api;

import com.azarenka.domain.Day;

import org.springframework.beans.factory.annotation.Qualifier;
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
public interface DayRepository {

    /**
     * returns list od days
     */
    List<Day> getAll();
}
