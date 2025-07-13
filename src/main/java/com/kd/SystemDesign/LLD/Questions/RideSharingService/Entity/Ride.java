package com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity;

import com.kd.SystemDesign.LLD.Questions.RideSharingService.enums.RideStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ride {
    private Address pickUpAddress;
    private String rideId;
    private String riderId;
    private String driverId;
    private RideStatus rideStatus;
    private Address pickupAddress;
    private Address dropAddress;
    private double estimatedFare;

    public Ride(String riderId, String driverId, Address pickupAddress, Address dropAddress) {
        this.rideId = "Ride-" + System.currentTimeMillis();
    }

    public void startRide() {
        this.rideStatus = RideStatus.STARTED;
    }

    public void endRide() {
        this.rideStatus = RideStatus.COMPLETED;
    }
}
