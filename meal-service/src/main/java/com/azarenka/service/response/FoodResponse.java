package com.azarenka.service.response;

import com.azarenka.domain.BaseEntity;
import com.azarenka.domain.Food;
import com.azarenka.domain.Measurement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class FoodResponse extends BaseEntity {

    private String title;
    private double weight;
    private int calories;
    private int protein;
    private int fats;
    private int carbohydrates;
    private String description;

    public FoodResponse(Food food) {
        this.title = food.getTitle();
        this.weight = food.getWeight();
        this.calories = food.getCalories();
        this.protein = food.getProtein();
        this.fats = food.getFats();
        this.carbohydrates = food.getCarbohydrates();
        this.description = getDescriptions(food.getMeasurement());
    }

    private String getDescriptions(Measurement measurement) {
        switch (measurement) {
            case GR:
                return "граммов";
            case DOSE:
                return "порций";
            case GLASS:
                return "стаканов";
            case THINGS:
                return "штук";
            case TEA_SPOON:
                return "чайных ложек";
        }
        return "неизвестный тип";
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FoodResponse that = (FoodResponse) o;

        return new EqualsBuilder()
            .appendSuper(super.equals(o))
            .append(weight, that.weight)
            .append(calories, that.calories)
            .append(protein, that.protein)
            .append(fats, that.fats)
            .append(carbohydrates, that.carbohydrates)
            .append(title, that.title)
            .append(description, that.description)
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
            .append(description)
            .toHashCode();
    }

    @Override
    public String toString() {
        return "FoodResponse{" +
            "title='" + title + '\'' +
            ", weight=" + weight +
            ", calories=" + calories +
            ", protein=" + protein +
            ", fats=" + fats +
            ", carbohydrates=" + carbohydrates +
            ", description='" + description + '\'' +
            '}';
    }
}
