package com.azarenka.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Meal
 * <p>
 * Copyright (C) ant-azarenka@mail.ru
 * </p>
 * Date 12 08 2019
 *
 * @author Anton Azarnka
 */
public class Meal extends BaseEntity {

    private String meal;

    /**
     * @return meal
     */
    public String getMeal() {
        return meal;
    }

    /**
     * Sets meal
     *
     * @param meal meal
     */
    public void setMeal(String meal) {
        this.meal = meal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Meal meal1 = (Meal) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(meal, meal1.meal)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(meal)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Meal{" +
                "meal='" + meal + '\'' +
                '}';
    }
}

