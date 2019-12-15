package com.azarenka.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;

public class Report {
    private BigDecimal food;
    private BigDecimal gas;
    private BigDecimal alcohol;
    private BigDecimal clothes;

    public Report() {
    }

    public BigDecimal getFood() {
        return food;
    }

    public void setFood(BigDecimal food) {
        this.food = food;
    }

    public BigDecimal getGas() {
        return gas;
    }

    public void setGas(BigDecimal gas) {
        this.gas = gas;
    }

    public BigDecimal getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(BigDecimal alcohol) {
        this.alcohol = alcohol;
    }

    public BigDecimal getClothes() {
        return clothes;
    }

    public void setClothes(BigDecimal clothes) {
        this.clothes = clothes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Report report = (Report) o;

        return new EqualsBuilder()
                .append(food, report.food)
                .append(gas, report.gas)
                .append(alcohol, report.alcohol)
                .append(clothes, report.clothes)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(food)
                .append(gas)
                .append(alcohol)
                .append(clothes)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Report{" +
                "food=" + food +
                ", gas=" + gas +
                ", alcohol=" + alcohol +
                ", clothes=" + clothes +
                '}';
    }
}
