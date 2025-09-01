package com.kd.SystemDesign.LLD.Questions.RideSharingService.Strategy;

import com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity.Driver;
import com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity.Ride;

import java.util.List;
import java.util.stream.Collectors;

public class NearestDriverStrategy implements DriverMatchingStrategy{
    @Override
    public List<Driver> findSuitableDrivers(Ride ride, List<Driver> availableDrivers) {
        return availableDrivers.stream()
                .filter(driver -> driver.isDriveAvailable())
                .sorted((d1, d2) -> {
                    double distance1 = 1;//d1.getAddress().getDistance(ride.getPickupAddress());
                    double distance2 = 2;//d2.getAddress().getDistance(ride.getPickUpAddress());
                    return Double.compare(distance1, distance2);
                })
                .limit(5) // Get top 5 nearest drivers
                .collect(Collectors.toList());
    }
}
