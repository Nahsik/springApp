package com.kd.SystemDesign.LLD.Questions.RideSharingService1.Entity;

import com.kd.SystemDesign.LLD.Questions.RideSharingService1.Enums.DriverStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Driver extends User {

    private String licenceNumber;
    private Location currLocation;
    private DriverStatus driverStatus;

    public Driver(String name, String phoneNumber,
                  String licenceNumber, Location currLocation) {
        super(name, phoneNumber);
        this.currLocation = currLocation;
        this.licenceNumber = licenceNumber;
        this.driverStatus = DriverStatus.AVAILABLE;
    }

    public boolean isDriverAvailable() {
        return driverStatus == DriverStatus.AVAILABLE;
    }

    public void goOnline() {
        driverStatus = DriverStatus.AVAILABLE;
    }

    public void goOffline() {
        driverStatus = DriverStatus.UNAVAILABLE;
    }

    public void acceptRide() {
        driverStatus = DriverStatus.IN_RIDE;
    }

    public void completeRide() {
        driverStatus = DriverStatus.AVAILABLE;
    }
}
