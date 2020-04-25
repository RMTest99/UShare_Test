package com.example.ushare_test.Models;

public class Profile {

    private String imageURL;

    public Profile() {
    }

    public Profile(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
