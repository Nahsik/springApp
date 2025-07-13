package com.kd.SystemDesign.LLD.Questions.RideSharingService1.Entity;

public class Location {
    private double latitude;
    private double longitude;

    public Location(int latitude, int longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double distance(Location otherLocation) {
        double x = latitude - otherLocation.latitude;
        double y = longitude - otherLocation.longitude;
        return Math.sqrt(x * x + y * y);
    }
}
