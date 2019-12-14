package com.azarenka.domain;

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
        if (!super.equals(o)) return false;
        Booker booker = (Booker) o;
        return Objects.equals(countPrice, booker.countPrice) &&
                Objects.equals(checkDate, booker.checkDate) &&
                type == booker.type &&
                Objects.equals(userEmail, booker.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), countPrice, checkDate, type, userEmail);
    }

    @Override
    public String toString() {
        return "Booker{" +
                "countPrice=" + countPrice +
                ", checkDate=" + checkDate +
                ", type=" + type +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
