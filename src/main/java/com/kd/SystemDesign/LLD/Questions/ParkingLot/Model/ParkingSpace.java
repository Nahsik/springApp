package com.kd.SystemDesign.LLD.Questions.ParkingLot.Model;

public class ParkingSpace {
    int spaceId;
    int floorId;
    Vehicle vehicle;
    int price;
    boolean isEmpty;

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isEmpty = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isEmpty = true;
    }
}
