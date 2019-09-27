package com.azarenka.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Day
 * <p>
 * Copyright (C) ant-azarenko@mail.ru
 * </p>
 * Date 12 08 2019
 *
 * @author Anton Azarnka
 */
public class Day extends BaseEntity {
    private String day;

    /**
     * @return day
     */
    public String getDay() {
        return day;
    }

    /**
     * Sets day
     *
     * @param day day
     */
    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Day day1 = (Day) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(day, day1.day)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(day)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Day{" +
            "day='" + day + '\'' +
            '}';
    }
}
