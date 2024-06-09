package com.example.physiofit;

import android.os.Parcel;
import android.os.Parcelable;

public class Workout implements Parcelable {
    private int imageResId;
    private String name;
    private String level;
    private String description;
    private int progress;
    private String details;

    public Workout(int imageResId, String name, String level, String description, int progress, String details) {
        this.imageResId = imageResId;
        this.name = name;
        this.level = level;
        this.description = description;
        this.progress = progress;
        this.details = details;
    }

    protected Workout(Parcel in) {
        imageResId = in.readInt();
        name = in.readString();
        level = in.readString();
        description = in.readString();
        progress = in.readInt();
        details = in.readString();
    }

    public static final Creator<Workout> CREATOR = new Creator<Workout>() {
        @Override
        public Workout createFromParcel(Parcel in) {
            return new Workout(in);
        }

        @Override
        public Workout[] newArray(int size) {
            return new Workout[size];
        }
    };

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public String getDescription() {
        return description;
    }

    public int getProgress() {
        return progress;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageResId);
        dest.writeString(name);
        dest.writeString(level);
        dest.writeString(description);
        dest.writeInt(progress);
        dest.writeString(details);
    }
}
