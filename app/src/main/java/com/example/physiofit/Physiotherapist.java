package com.example.physiofit;

import android.os.Parcel;
import android.os.Parcelable;

public class Physiotherapist implements Parcelable {
    private int profilePicture; // Assuming you use resource IDs for images
    private String name;
    private String specialization;
    private float rating;

    public Physiotherapist(int profilePicture, String name, String specialization, float rating) {
        this.profilePicture = profilePicture;
        this.name = name;
        this.specialization = specialization;
        this.rating = rating;
    }

    protected Physiotherapist(Parcel in) {
        profilePicture = in.readInt();
        name = in.readString();
        specialization = in.readString();
        rating = in.readFloat();
    }

    public static final Creator<Physiotherapist> CREATOR = new Creator<Physiotherapist>() {
        @Override
        public Physiotherapist createFromParcel(Parcel in) {
            return new Physiotherapist(in);
        }

        @Override
        public Physiotherapist[] newArray(int size) {
            return new Physiotherapist[size];
        }
    };

    public int getProfilePicture() {
        return profilePicture;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public float getRating() {
        return rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(profilePicture);
        parcel.writeString(name);
        parcel.writeString(specialization);
        parcel.writeFloat(rating);
    }
}
