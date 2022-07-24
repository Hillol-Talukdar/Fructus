package com.example.fructus;

import java.util.ArrayList;

public class Fruit {
    private int id;
    private String title;
    private String headline;
    private String image;
    private String description;
    private ArrayList<String> gradientColors;
    private ArrayList<String> nutrition;

    public Fruit(int id, String title, String headline, String image, String description, ArrayList<String> gradientColors, ArrayList<String> nutrition) {
        this.id = id;
        this.title = title;
        this.headline = headline;
        this.image = image;
        this.description = description;
        this.gradientColors = gradientColors;
        this.nutrition = nutrition;
    }

    public Fruit(int id, String title, String headline, String image, String description) {
        this.id = id;
        this.title = title;
        this.headline = headline;
        this.image = image;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getGradientColors() {
        return gradientColors;
    }

    public void setGradientColors(ArrayList<String> gradientColors) {
        this.gradientColors = gradientColors;
    }

    public ArrayList<String> getNutrition() {
        return nutrition;
    }

    public void setNutrition(ArrayList<String> nutrition) {
        this.nutrition = nutrition;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", headline='" + headline + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
