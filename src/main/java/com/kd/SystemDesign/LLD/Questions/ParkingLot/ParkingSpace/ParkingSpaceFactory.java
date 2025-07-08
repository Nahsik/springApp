package com.kd.SystemDesign.LLD.Questions.ParkingLot.ParkingSpace;

import com.kd.SystemDesign.LLD.Questions.ParkingLot.Model.ParkingSpace;
import com.kd.SystemDesign.LLD.Questions.ParkingLot.Model.Vehicle;

public class ParkingSpaceFactory {
    public ParkingSpace getParkingSpace(Vehicle vehicle) {
        return switch (vehicle.getVehicleType()) {
            case TWO -> new TwoWheelerSpace();
            case FOUR -> new FourWheelerSpace();
            case HEAVY -> new HeavyWheelerSpace();
        };
    }
}
