package com.activity.healthstuff4;

public class userInfo
{
    public String username, weight,height, calories, goalweight;

    public userInfo()
    {
        //empty constructor do not remove
    }


    public userInfo(String username, String weight, String height, String calories, String goalweight) {
        this.username = username;
        this.weight = weight;
        this.height = height;
        this.calories = calories;
        this.goalweight = goalweight;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getGoalweight() {
        return goalweight;
    }

    public void setGoalweight(String goalweight) {
        this.goalweight = goalweight;
    }

    public String ToString()
    {
        return "Height:" + " " + " " + height + "\r\n" + "Weight:" + " " + " " + weight + "\r\n" + "Target Weight:" + " " + " " + goalweight +
                "\r\n" + "Target Calorie Intake:" + " " + " " + calories;
    }

}

