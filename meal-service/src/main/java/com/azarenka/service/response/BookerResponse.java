package com.azarenka.service.response;

import com.azarenka.domain.Booker;
import com.azarenka.domain.CheckType;
import com.azarenka.service.impl.auth.UserPrinciple;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BookerResponse {

    private String countPrice;
    private LocalDate checkDate;
    private String type;
    private String userEmail;

    public Booker asBooker(){
        Booker booker = new Booker();
        booker.setCountPrice(new BigDecimal(countPrice));
        booker.setType(insertType());
        booker.setCheckDate(LocalDate.now());
        return booker;
    }

    private CheckType insertType(){
        switch (type) {
            case  "FOOD": return CheckType.FOOD;
            case  "DRINK": return CheckType.DRINK;
            case  "GAS": return CheckType.GAS;
            case  "CLOTHES": return CheckType.CLOTHES;
        }
        return null;
    }

    public String getCountPrice() {
        return countPrice;
    }

    public void setCountPrice(String countPrice) {
        this.countPrice = countPrice;
    }

    public LocalDate getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(LocalDate checkDate) {
        this.checkDate = checkDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
