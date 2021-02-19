
public class userInfo
{
    public String Username, Weight,Height, Calories, Goalweight;

    public userInfo()
    {
        //empty constructor do not remove
    }

    public userInfo(String username, String height, String weight, String targetWeight, String calories)
    {
        Username = username;
        Height = height;
        Weight = weight;
        Calories = calories;
        Goalweight = targetWeight;
    }
    public String getHeight() {
        return Height;
    }

    public void setHeight(String height) {
        Height = height;
    }

    public String getWeight() {
        return Weight;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }

    public String getGoalWeight() {
        return Goalweight;
    }

    public void setGoalWeight(String goalWeight) {
        Goalweight = goalWeight;
    }

    public String getCalories() {
        return Calories;
    }

    public void setCalories(String calories) {
        Calories = calories;
    }


    public String ToString()
    {
        return "Height:" + " " + " " + Height + "\r\n" + "Weight:" + " " + " " + Weight + "\r\n" + "Target Weight:" + " " + " " + Goalweight +
                "\r\n" + "Target Calorie Intake:" + " " + " " + Calories;
    }

}

