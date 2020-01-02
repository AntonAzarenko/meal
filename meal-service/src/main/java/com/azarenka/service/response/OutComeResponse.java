package com.azarenka.service.response;

import com.azarenka.domain.Booker;
import com.azarenka.service.util.TypeConverter;
import com.azarenka.service.util.TimeUtil;

public class OutComeResponse {
    private String date;
    private String price;
    private String comment;
    private String type;
    private String icon;

    public OutComeResponse(Booker booker) {
        this.comment = booker.getComment();
        this.type = TypeConverter.getTypeToString(booker.getType());
        this.date = TimeUtil.timeToString(booker.getCheckDate());
        this.price = String.valueOf(booker.getCountPrice());
        this.icon = TypeConverter.getTypeOfIcon(booker.getType());
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
