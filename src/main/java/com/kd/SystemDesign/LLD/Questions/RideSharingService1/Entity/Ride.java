package com.kd.SystemDesign.LLD.Questions.RideSharingService1.Entity;

import com.kd.SystemDesign.LLD.Questions.RideSharingService1.Enums.PaymentStatus;
import com.kd.SystemDesign.LLD.Questions.RideSharingService1.Enums.RideStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Ride {
    private final String id;
    private Driver driver;
    private final Rider rider;
    private final Location pickUpLocation;
    private final Location droupLocation;
    private RideStatus status;
    private PaymentStatus paymentStatus;
    private double fare;

    public Ride(Rider rider, Location pickUpLocation, Location droupLocation) {
        this.id = UUID.randomUUID().toString();
        this.rider = rider;
        this.pickUpLocation = pickUpLocation;
        this.droupLocation = droupLocation;
        this.paymentStatus = PaymentStatus.PENDING;
    }

}
