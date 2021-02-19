package com.activity.healthstuff4;

import android.media.Image;

public class DailyLogUpdates {
    public String meal, calories, date;

    public DailyLogUpdates(String meal, String calories, String date) {
        this.meal = meal;
        this.calories = calories;
        this.date = date;
    }

    public DailyLogUpdates() {
        //empty constructor
    }

    //getters
    public String getMeal() {
        return meal;
    }

    public String getCalories() {
        return calories;
    }

    public String getDate() {
        return date;
    }

    //setters
    public void setMeal(String meal) {
        this.meal = meal;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public void setDate(String date) {
        this.date = date;
    }





    
}
