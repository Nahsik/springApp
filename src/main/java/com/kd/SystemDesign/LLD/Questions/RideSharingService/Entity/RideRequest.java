package com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity;

import java.util.Date;


public class RideRequest {
    private int riderId;
    private Address fromLocation;
    private Address dropLocation;
    private Date timeStamp;
    private static int count = 0;

    public RideRequest(Address dropLocation, Address fromLocation) {
        this.dropLocation = dropLocation;
        this.timeStamp = new Date();
        this.riderId = getNextRideId();
    }

    private synchronized int getNextRideId() {
        count++;
        return count;
    }
}
