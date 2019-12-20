package com.azarenka.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Booker extends BaseEntity {

    private BigDecimal countPrice;
    private LocalDate checkDate;
    private CheckType type;
    private String userEmail;

    public Booker() {
    }

    public BigDecimal getCountPrice() {
        return countPrice;
    }

    public void setCountPrice(BigDecimal countPrice) {
        this.countPrice = countPrice;
    }

    public LocalDate getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(LocalDate checkDate) {
        this.checkDate = checkDate;
    }

    public CheckType getType() {
        return type;
    }

    public void setType(CheckType type) {
        this.type = type;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Booker booker = (Booker) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(countPrice, booker.countPrice)
                .append(checkDate, booker.checkDate)
                .append(type, booker.type)
                .append(userEmail, booker.userEmail)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(countPrice)
                .append(checkDate)
                .append(type)
                .append(userEmail)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Booker{" +
                "id=" + getId() +
                ", countPrice=" + countPrice +
                ", checkDate=" + checkDate +
                ", type=" + type +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
