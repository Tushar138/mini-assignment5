package com.training.nagarro.mini.assignment5.model;

public class User {
    private String userId;
    private String name;
    private BerthType preferredBerth;
    private MealPreference mealPreference;

    public User(String userId, String name, BerthType preferredBerth, MealPreference mealPreference) {
        this.userId = userId;
        this.name = name;
        this.preferredBerth = preferredBerth;
        this.mealPreference = mealPreference;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public BerthType getPreferredBerth() {
        return preferredBerth;
    }

    public MealPreference getMealPreference() {
        return mealPreference;
    }

    public void setPreferredBerth(BerthType berth) {
        this.preferredBerth = berth;
    }

    public void setMealPreference(MealPreference preference) {
        this.mealPreference = preference;
    }
}
