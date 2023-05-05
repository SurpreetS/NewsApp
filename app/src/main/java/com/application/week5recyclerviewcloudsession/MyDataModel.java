

/*
                Name = Surpreet singh
                Student Id = 218663803
                Unit = SIT305-Task5.1
*/


package com.application.week5recyclerviewcloudsession;

// This line declares the MyDataModel class
public class MyDataModel {


    // These lines declare three instance variables, Organization, description, and image
    String Organization, description;
    int image;

    // This is the constructor for the MyDataModel class which takes in a name, description, and image parameter
    public MyDataModel(String name, String description, int image) {
        // This line initializes the Organization variable with the name parameter
        this.Organization = name;
        // This line initializes the description variable with the description parameter
        this.description = description;
        // This line initializes the image variable with the image parameter
        this.image = image;
    }

    // This method returns the value of the Organization instance variable
    public String getOrganization() {
        return Organization;
    }

    // This method returns the value of the description instance variable
    public String getDescription() {
        return description;
    }

    // This method returns the value of the image instance variable
    public int getImage() {
        return image;
    }
}
