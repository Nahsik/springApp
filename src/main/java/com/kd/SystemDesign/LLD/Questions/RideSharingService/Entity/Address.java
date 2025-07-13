package com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity;

import lombok.Getter;

@Getter
public class Address {
    private double lang;
    private double lat;

    public Address(double lang, double lat) {
        this.lang = lang;
        this.lat = lat;
    }

    public double getDistance(Address other) {
        double dx = this.lang - other.lang;
        double dy = this.lat - other.lat;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
