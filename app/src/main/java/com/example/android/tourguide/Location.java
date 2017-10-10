package com.example.android.tourguide;

/**
 * Created by Irmantas Čivilis on 2017.05.29.
 * <p>
 * Location represents a place, sight, historical building etc. to see and visit in Vilnius.
 */


public class Location {

    // Name of the location
    private String mName;

    // Image resource ID for the location
    private int mImageResourceId;

    // Description of the location
    private String mDescription;

    // Coordinates in the map
    private String mCoordinates;


    /**
     * Constructor. Create a new Location object.
     */

    public Location(String name, int imageResourceId, String description, String coordinates) {
        mName = name;
        mImageResourceId = imageResourceId;
        mDescription = description;
        mCoordinates = coordinates;
    }

    /**
     * Getters. Methods to access values of Location object's variables
     */

    public String getName() {
        return mName;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getCoordinates() {
        return mCoordinates;
    }

    /**
     * toString method
     */
    @Override
    public String toString() {
        return "Location{" +
                "mName='" + mName + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mDescription='" + mDescription + '\'' +
                ", mCoordinates='" + mCoordinates + '\'' +
                '}';
    }
}
