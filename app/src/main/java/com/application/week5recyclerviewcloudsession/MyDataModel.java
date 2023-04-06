package com.application.week5recyclerviewcloudsession;

public class MyDataModel {


    String name, description;
    int image;

    public MyDataModel(String name, String description, int image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }
}
