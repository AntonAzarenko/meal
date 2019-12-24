package com.azarenka.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;

public class Report {
    private BigDecimal food;
    private BigDecimal gas;
    private BigDecimal alcohol;
    private BigDecimal clothes;
    private BigDecimal credit;
    private BigDecimal pets;
    private BigDecimal home;
    private String month;
    private String year;

    public Report() {
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public BigDecimal getPets() {
        return pets;
    }

    public void setPets(BigDecimal pets) {
        this.pets = pets;
    }

    public BigDecimal getHome() {
        return home;
    }

    public void setHome(BigDecimal home) {
        this.home = home;
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
            .append(credit, report.credit)
            .append(pets, report.pets)
            .append(home, report.home)
            .append(month, report.month)
            .append(year, report.year)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(food)
            .append(gas)
            .append(alcohol)
            .append(clothes)
            .append(credit)
            .append(pets)
            .append(home)
            .append(year)
            .append(home)
            .toHashCode();
    }

    @Override
    public String toString() {
        return "Report{" +
            "food=" + food +
            ", gas=" + gas +
            ", alcohol=" + alcohol +
            ", clothes=" + clothes +
            ", credit=" + credit +
            ", pets=" + pets +
            ", home=" + home +
            ", month" + month +
            ", year" + year +
                '}';
    }
}
