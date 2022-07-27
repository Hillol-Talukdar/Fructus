package com.example.fructus;

import java.util.ArrayList;

public class IntroductionScreenItem {
    private String Title;
    private String headline;
    private String image;
    private ArrayList<String> gradientColors;

    public IntroductionScreenItem(String title, String headline, String image, ArrayList<String> gradientColors) {
        Title = title;
        this.headline = headline;
        this.image = image;
        this.gradientColors = gradientColors;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
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

    public ArrayList<String> getGradientColors() {
        return gradientColors;
    }

    public void setGradientColors(ArrayList<String> gradientColors) {
        this.gradientColors = gradientColors;
    }

    @Override
    public String toString() {
        return "IntroductionScreenItem{" +
                "Title='" + Title + '\'' +
                ", headline='" + headline + '\'' +
                ", image='" + image + '\'' +
                ", gradientColors=" + gradientColors +
                '}';
    }
}
