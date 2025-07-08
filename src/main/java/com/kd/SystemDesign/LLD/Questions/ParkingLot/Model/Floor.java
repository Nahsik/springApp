package com.kd.SystemDesign.LLD.Questions.ParkingLot.Model;

import java.util.List;

public class Floor {
    int floorId;
    List<ParkingSpace> parkingSpaces;
    boolean isEmpty;

    public void addParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpaces.add(parkingSpace);
    }

    public void removeParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpaces.remove(parkingSpace);
    }
}
