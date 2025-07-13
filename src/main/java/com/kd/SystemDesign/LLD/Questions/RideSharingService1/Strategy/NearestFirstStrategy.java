package com.kd.SystemDesign.LLD.Questions.RideSharingService1.Strategy;

import com.kd.SystemDesign.LLD.Questions.RideSharingService1.Entity.Driver;
import com.kd.SystemDesign.LLD.Questions.RideSharingService1.Entity.Location;

import java.util.List;
import java.util.stream.Collectors;

public class NearestFirstStrategy implements FindDriverStrategy{

    @Override
    public List<Driver> findDrivers(List<Driver> drivers, Location pickUpLocation) {
        return drivers.stream()
                .filter(driver -> driver.isDriverAvailable())
                .sorted((d1, d2) -> {
                    double distance1 = d1.getCurrLocation().distance(pickUpLocation);
                    double distance2 = d2.getCurrLocation().distance(pickUpLocation);
                    return Double.compare(distance1, distance2);
                })
                .limit(5) // Get top 5 nearest drivers
                .collect(Collectors.toList());
    }
}
