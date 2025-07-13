package com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity;

import com.kd.SystemDesign.LLD.Questions.RideSharingService.enums.DriverStatus;
import com.kd.SystemDesign.LLD.Questions.RideSharingService.enums.VehicleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Driver extends User {
    private VehicleType vehicle;
    private DriverStatus driverStatus;
    private double ratting;

    public Driver(String name, String phoneNumber, VehicleType vehicle, Address address) {
        super(name, phoneNumber, address);
        this.vehicle = vehicle;
        this.driverStatus = DriverStatus.UNAVAILABLE;
        this.ratting = 5.0;
    }

    public boolean isDriveAvailable() {
        return driverStatus == DriverStatus.AVAILABLE;
    }


    public void goOnline() {
       driverStatus = DriverStatus.AVAILABLE;
    }

    public void goOffline() {
     driverStatus = DriverStatus.UNAVAILABLE;
    }

    public void acceptRide(Ride ride) {
        this.driverStatus = DriverStatus.ON_RIDE;
        System.out.println("Driver " + getName() + " accepted ride " + ride.getRideId());
    }

    public void rejectRide(Ride ride) {
        System.out.println("Driver " + getName() + " rejected ride " + ride.getRideId());
    }

    public void completeRide(Ride ride) {
        this.driverStatus = DriverStatus.AVAILABLE;
        System.out.println("Driver " + getName() + " completed ride " + ride.getRideId());
    }

}

