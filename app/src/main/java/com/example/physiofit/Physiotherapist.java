package com.example.physiofit;
public class Physiotherapist {
    private int profilePicture; // Assuming you use resource IDs for images
    private String name;
    private float rating;

    public Physiotherapist(int profilePicture, String name, float rating) {
        this.profilePicture = profilePicture;
        this.name = name;
        this.rating = rating;
    }

    public int getProfilePicture() {
        return profilePicture;
    }

    public String getName() {
        return name;
    }

    public float getRating() {
        return rating;
    }
}

