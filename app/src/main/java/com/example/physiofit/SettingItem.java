package com.example.physiofit;
public class SettingItem {
    private int icon;
    private String title;
    private String subtitle;

    public SettingItem(int icon, String title, String subtitle) {
        this.icon = icon;
        this.title = title;
        this.subtitle = subtitle;
    }

    public int getIcon() {
        return icon;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }
}
