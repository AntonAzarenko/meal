package com.azarenka.service.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

@Component
public class TimeUtil {

    private static final Map<String, Month> months = new HashMap<>();

    @PostConstruct
    public void init() {
        months.put("Январь", Month.JANUARY);
        months.put("Февраль", Month.FEBRUARY);
        months.put("Март", Month.MARCH);
        months.put("Апрель", Month.APRIL);
        months.put("Май", Month.MAY);
        months.put("Июнь", Month.JUNE);
        months.put("Июль", Month.JULY);
        months.put("Август", Month.AUGUST);
        months.put("Сентярь", Month.SEPTEMBER);
        months.put("Отябрь", Month.OCTOBER);
        months.put("Ноябрь", Month.NOVEMBER);
        months.put("Декабрь", Month.DECEMBER);
    }

    public static String getMonth(LocalDate date) {
        Month month = date.getMonth();
        return months.entrySet()
            .stream()
            .filter(pair -> pair.getValue().equals(month))
            .findFirst()
            .map(Entry::getKey)
            .orElse(null);
    }
}
