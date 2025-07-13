package com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity;


import java.util.ArrayList;
import java.util.List;

public class Rider extends User {

    private List<Ride> rides;

    public Rider(String name, String phoneNumber, Address address) {
        super(name, phoneNumber, address);
        this.rides = new ArrayList<>();
    }

    public Ride requestRide(Address dropLocation) {
        Ride ride = new Ride(this.getUserId(), null, this.getAddress(), dropLocation);
        rides.add(ride);
        return ride;
    }
}
