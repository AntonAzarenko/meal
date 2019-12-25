package com.azarenka.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;

public class Report {
    private BigDecimal  DEFAULT_VALUE = BigDecimal.ZERO;

    private BigDecimal food = DEFAULT_VALUE;
    private BigDecimal gas = DEFAULT_VALUE;
    private BigDecimal alcohol = DEFAULT_VALUE;
    private BigDecimal clothes = DEFAULT_VALUE;
    private BigDecimal credit = DEFAULT_VALUE;
    private BigDecimal pets = DEFAULT_VALUE;
    private BigDecimal home = DEFAULT_VALUE;
    private BigDecimal profit = DEFAULT_VALUE;
    private String year;
    private String month;

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

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Report report = (Report) o;

        return new EqualsBuilder()
                .append(DEFAULT_VALUE, report.DEFAULT_VALUE)
                .append(food, report.food)
                .append(gas, report.gas)
                .append(alcohol, report.alcohol)
                .append(clothes, report.clothes)
                .append(credit, report.credit)
                .append(pets, report.pets)
                .append(home, report.home)
                .append(profit, report.profit)
                .append(year, report.year)
                .append(month, report.month)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(DEFAULT_VALUE)
                .append(food)
                .append(gas)
                .append(alcohol)
                .append(clothes)
                .append(credit)
                .append(pets)
                .append(home)
                .append(profit)
                .append(year)
                .append(month)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Report{" +
                "DEFAULT_VALUE=" + DEFAULT_VALUE +
                ", food=" + food +
                ", gas=" + gas +
                ", alcohol=" + alcohol +
                ", clothes=" + clothes +
                ", credit=" + credit +
                ", pets=" + pets +
                ", home=" + home +
                ", profit=" + profit +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                '}';
    }
}
