package com.azarenka.service.response;

import com.azarenka.domain.Booker;
import com.azarenka.service.exeptions.IncorrectDataException;
import com.azarenka.service.util.TypeConverter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BookerResponse {
    @NotNull
    private String countPrice;
    private LocalDate checkDate;
    @NotBlank
    private String type;
    private String userEmail;
    private String comment;

    public Booker asBooker(){
        Booker booker = new Booker();
        booker.setCountPrice(validator());//TODO validator should be rewrite!!!
        booker.setType(TypeConverter.getCheckType(type));
        booker.setCheckDate(LocalDate.now());
        booker.setComment(comment);
        return booker;
    }

    //TODO write validator to field countPrice
    private BigDecimal validator(){
        try {
            if(this.countPrice.equals("")){
                throw new IncorrectDataException("Поле не может быть пустым!!!");
            }
            BigDecimal price = new BigDecimal(countPrice);
        } catch (NumberFormatException ex){
            throw new IncorrectDataException("Не корректно введены данные!!!");
        }
        return new BigDecimal(countPrice);
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
