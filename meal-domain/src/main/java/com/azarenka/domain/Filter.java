package com.azarenka.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Filter {

    private Integer fats;
    private Integer protein;
    private Integer carbohydrates;

    public Filter() {
    }

    public Integer getFats() {
        return fats;
    }

    public void setFats(Integer fats) {
        this.fats = fats;
    }

    public Integer getProtein() {
        return protein;
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    public Integer getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Integer carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Filter filter = (Filter) o;

        return new EqualsBuilder()
                .append(fats, filter.fats)
                .append(protein, filter.protein)
                .append(carbohydrates, filter.carbohydrates)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(fats)
                .append(protein)
                .append(carbohydrates)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Filter{" +
                "fats=" + fats +
                ", protein=" + protein +
                ", carbohydrates=" + carbohydrates +
                '}';
    }
}
