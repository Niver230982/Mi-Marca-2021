package com.niverarrigonni.mimarca.webservices.sesion;

public class LocationData {
    private static LocationData instance;

    private double latitude;
    private double longitude;

    private LocationData() {}

    public static LocationData getInstance() {
        if( instance == null) {
            instance = new LocationData();
        }
        return instance;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
