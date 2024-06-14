package com.example.physiofit;

import java.util.Map;

public class User {
    private String username;
    private String email;
    private Map<String, Workout> workouts;  // Map of workouts
    private Map<String, Chat> chats;        // Map of chats

    // Default constructor is required for Firebase deserialization
    public User() {
    }

    // Constructor with parameters
    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(Map<String, Workout> workouts) {
        this.workouts = workouts;
    }

    public Map<String, Chat> getChats() {
        return chats;
    }

    public void setChats(Map<String, Chat> chats) {
        this.chats = chats;
    }
}
