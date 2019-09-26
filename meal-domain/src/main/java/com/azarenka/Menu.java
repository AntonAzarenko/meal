package com.azarenka;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

/**
 * Menu
 * <p>
 * Copyright (C) ant-azarenko@mail.ru
 * </p>
 * Date 12 08 2019
 *
 * @author Anton Azarnko
 */
public class Menu extends BaseEntity {

    private String userId;
    private String foodId;
    private String dayId;
    private String mealId;
    private String email;
    private int countFood;
    private Date date;
    private String setTitle;

    /**
     * @return count foods
     */
    public int getCountFood() {
        return countFood;
    }

    /**
     * Sets count food
     *
     * @param countFood count food
     */
    public void setCountFood(int countFood) {
        this.countFood = countFood;
    }

    /**
     * @return user id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets user id
     *
     * @param userId user id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return food id
     */
    public String getFoodId() {
        return foodId;
    }

    /**
     * Sets food id
     *
     * @param foodId food id
     */
    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    /**
     * @return day id
     */
    public String getDayId() {
        return dayId;
    }

    /**
     * Sets day id
     *
     * @param dayId day id
     */
    public void setDayId(String dayId) {
        this.dayId = dayId;
    }

    /**
     * @return meal id
     */
    public String getMealId() {
        return mealId;
    }

    /**
     * Sets meal id
     *
     * @param mealId meal id
     */
    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    /**
     * @return user email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets user email
     *
     * @param email user email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return date of create
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date of create
     *
     * @param date date of create
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return title of set
     */
    public String getTitle() {
        return setTitle;
    }

    /**
     * Setss title of set
     *
     * @param setTitle title of set
     */
    public void setTitle(String setTitle) {
        this.setTitle = setTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(userId, menu.userId)
                .append(foodId, menu.foodId)
                .append(dayId, menu.dayId)
                .append(mealId, menu.mealId)
                .append(email, menu.email)
                .append(countFood, menu.countFood)
                .append(setTitle, menu.setTitle)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(userId)
                .append(foodId)
                .append(dayId)
                .append(mealId)
                .append(email)
                .append(countFood)
                .append(setTitle)
                .toHashCode();
    }
}
