package com.kd.SystemDesign.LLD.Questions.RideSharingService1.Strategy;

import com.kd.SystemDesign.LLD.Questions.RideSharingService1.Entity.Location;

public class BasicFairCalculation implements FairCalculationStrategy {
    @Override
    public double calculateFair(Location pickUpLocation, Location droupLocation) {
        int baseFair = 10;
        int fairPerKm = 7;
        return baseFair + fairPerKm * pickUpLocation.distance(droupLocation);
    }
}
