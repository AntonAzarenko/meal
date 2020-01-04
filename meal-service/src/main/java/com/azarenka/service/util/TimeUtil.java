package com.azarenka.service.util;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@Component
public class TimeUtil {

    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd";
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
    private static final Map<String, Month> months = new HashMap<>();

    public static String timeToString(LocalDate ldt) {
        return ldt == null ? "" : ldt.format(DATE_TIME_FORMATTER);
    }

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

    public static String getMonth(String year, String month) {
        return getMonth(LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), 1));
    }

    public static String dayToString(DayOfWeek dayOfWeek) {
        String day = dayOfWeek.toString().toLowerCase();
        char arrayDay[] = day.toCharArray();
        String oldChar = String.valueOf(arrayDay[0]);
        String newChar = oldChar.toUpperCase();
        char a = newChar.charAt(0);
        arrayDay[0] = a;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arrayDay.length; i++) {
            builder.append(arrayDay[i]);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(dayToString(DayOfWeek.FRIDAY));
    }
}
