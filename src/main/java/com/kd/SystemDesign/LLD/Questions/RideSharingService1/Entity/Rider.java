package com.kd.SystemDesign.LLD.Questions.RideSharingService1.Entity;

public class Rider extends User {
    private Ride currentTrip;

    public Rider(String name, String phoneNumber) {
        super(name, phoneNumber);
        currentTrip = null;
    }

    public synchronized void assignTrip(Ride trip) {
        this.currentTrip = trip;
    }

    public synchronized void completeTrip() {
        this.currentTrip = null;
    }

    public Ride getCurrentTrip() {
        return currentTrip;
    }
}
