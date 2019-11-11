package com.azarenka.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Food
 * <p>
 * Copyright (C) ant-azarenko@mail.ru
 * </p>
 * Date 21.07.2019
 *
 * @author Anton Azarnka
 */
public class Food extends BaseEntity {

    private String title;
    private double weight;
    private int calories;
    private int protein;
    private int fats;
    private int carbohydrates;
    private Measurement measurement;

    public com.azarenka.domain.Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(com.azarenka.domain.Measurement measurement) {
        this.measurement = measurement;
    }

    /**
     * @return gets title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title
     *
     * @param title title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets weight
     *
     * @param weight weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @return calories
     */
    public int getCalories() {
        return calories;
    }

    /**
     * Sets calories
     *
     * @param calories calories
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }

    /**
     * @return protein
     */
    public int getProtein() {
        return protein;
    }

    /**
     * Sets protein
     *
     * @param protein protein
     */
    public void setProtein(int protein) {
        this.protein = protein;
    }

    /**
     * @return fats
     */
    public int getFats() {
        return fats;
    }

    /**
     * Sets fats
     *
     * @param fats
     */
    public void setFats(int fats) {
        this.fats = fats;
    }

    /**
     * @return carbohydrates
     */
    public int getCarbohydrates() {
        return carbohydrates;
    }

    /**
     * Sets carbohydrates
     *
     * @param carbohydrates carbohydrates
     */
    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Food food = (Food) o;

        return new EqualsBuilder()
            .appendSuper(super.equals(o))
            .append(weight, food.weight)
            .append(calories, food.calories)
            .append(protein, food.protein)
            .append(fats, food.fats)
            .append(carbohydrates, food.carbohydrates)
            .append(title, food.title)
            .append(measurement, food.measurement)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .appendSuper(super.hashCode())
            .append(title)
            .append(weight)
            .append(calories)
            .append(protein)
            .append(fats)
            .append(carbohydrates)
            .append(measurement)
            .toHashCode();
    }

    @Override
    public String toString() {
        return "Food{" +
            "title='" + title + '\'' +
            ", weight=" + weight +
            ", calories=" + calories +
            ", protein=" + protein +
            ", fats=" + fats +
            ", carbohydrates=" + carbohydrates +
            ", measurement=" + measurement +
            '}';
    }
}
