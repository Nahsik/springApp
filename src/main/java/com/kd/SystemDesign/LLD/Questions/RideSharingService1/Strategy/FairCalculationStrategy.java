package com.kd.SystemDesign.LLD.Questions.RideSharingService1.Strategy;

import com.kd.SystemDesign.LLD.Questions.RideSharingService1.Entity.Location;

public interface FairCalculationStrategy {

    double calculateFair(Location pickUpLocation, Location droupLocation);
}
