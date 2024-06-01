package com.example.physiofit;
public class SettingItem {
    private String name;
    private int iconResId;

    public SettingItem(String name, int iconResId) {
        this.name = name;
        this.iconResId = iconResId;
    }

    public String getName() {
        return name;
    }

    public int getIconResId() {
        return iconResId;
    }
}