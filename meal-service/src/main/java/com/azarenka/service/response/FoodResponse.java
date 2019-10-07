package com.azarenka.service.response;

import com.azarenka.domain.Food;

public class FoodResponse{

    private String title;
    private double weight;
    private int calories;
    private int protein;
    private int fats;
    private int carbohydrates;
    private String content;

    public FoodResponse(Food food) {
        this.content = content;
    }
}
