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
