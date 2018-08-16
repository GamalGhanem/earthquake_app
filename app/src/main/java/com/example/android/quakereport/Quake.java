package com.example.android.quakereport;

/**
 * Created by Gamal Ghanem on 7/31/2018.
 */

public class Quake {

    /**
     * defines the strength of the quake
     */
    private double strength;

    /**
     * define where the quake occurred
     */
    private String location;

    /**
     * defines the date of the quake
     */
    private long date;

    /**
     * defines the url of the earthquake
     */
    private String quakeURL;


    /**
     * constructor to set the values of the quake attributes
     * @param strength
     * @param location
     * @param date
     */
    public Quake (double strength, String location, long date, String quakeURL) {
        this.strength = strength;
        this.location = location;
        this.date = date;
        this.quakeURL = quakeURL;
    }

    /**
     * getter of the strength of the quake
     * @return the string value of the quake strength
     */
    public double getStrength() {
        return strength;
    }

    /**
     * getter of the location of the quake
     * @return the string value of the quake location
     */
    public String getLocation() {
        return location;
    }

    /**
     * getter of the date of the quake
     * @return the string value of the quake date
     */
    public long getDate() {
        return date;
    }

    /**
     * getter of the quake url
     * @return the string value of the url
     */
    public String getQuakeURL() {
        return quakeURL;
    }
}
