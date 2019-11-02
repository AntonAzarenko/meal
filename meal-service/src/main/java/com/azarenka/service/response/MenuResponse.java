package com.azarenka.service.response;

import com.azarenka.domain.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class MenuResponse extends BaseEntity implements Comparable {

    private String day;
    private String meal;
    private String count;
    private String food;
    private String fats;
    private String protein;
    private String carbohydrates;
    private String setTitle;

    public String getSetTitle() {
        return setTitle;
    }

    public void setSetTitle(String setTitle) {
        this.setTitle = setTitle;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getFats() {
        return fats;
    }

    public void setFats(String fats) {
        this.fats = fats;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(String carbohydrates) {
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

        MenuResponse that = (MenuResponse) o;

        return new EqualsBuilder()
                .append(day, that.day)
                .append(meal, that.meal)
                .append(count, that.count)
                .append(food, that.food)
                .append(fats, that.fats)
                .append(protein, that.protein)
                .append(carbohydrates, that.carbohydrates)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(day)
                .append(meal)
                .append(count)
                .append(food)
                .append(fats)
                .append(protein)
                .append(carbohydrates)
                .toHashCode();
    }

    @Override
    public int compareTo(Object o) {
        return this.compareTo(o);
    }

    public int compareTo(String meal) {
        return this.meal.compareTo(meal);
    }

}
