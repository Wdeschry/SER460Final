package finalProject;

public class Meal {
    private String publisherName;
    private String mealPlanType; // mealIdea, dailyMeal, weeklyMeal
    private String mealName;
    private String cuisineType; // Chinese, Italian, Brazilian, etc
    private String cookTime; // 15minutes, etc
    private String mealType; // (Optional) breakfast, lunch, dinner
    private String dayOfWeek; // (Optional) monday, tuesday, wednesday, etc

    // mealIdea
    Meal(String publisherName, String mealPlanType, String mealName, String cuisineType, String cookTime) {
        this.publisherName = publisherName;
        this.mealPlanType = mealPlanType;
        this.mealName = mealName;
        this.cuisineType = cuisineType;
        this.cookTime = cookTime;
    }

    // dailyMeal
    Meal(String publisherName, String mealPlanType, String mealName, String cuisineType, String cookTime, String mealType) {
        this.publisherName = publisherName;
        this.mealPlanType = mealPlanType;
        this.mealName = mealName;
        this.cuisineType = cuisineType;
        this.cookTime = cookTime;
        this.mealType = mealType;
    }

    //weeklyMeal
    Meal(String publisherName, String mealPlanType, String mealName, String cuisineType, String cookTime, String mealType, String dayOfWeek) {
        this.publisherName = publisherName;
        this.mealPlanType = mealPlanType;
        this.mealName = mealName;
        this.cuisineType = cuisineType;
        this.cookTime = cookTime;
        this.mealType = mealType;
        this.dayOfWeek = dayOfWeek;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getMealPlanType() {
        return mealPlanType;
    }

    public void setMealPlanType(String mealPlanType) {
        this.mealPlanType = mealPlanType;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getCookTime() {
        return cookTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}