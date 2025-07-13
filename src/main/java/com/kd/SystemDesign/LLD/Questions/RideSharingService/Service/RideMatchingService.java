package com.kd.SystemDesign.LLD.Questions.RideSharingService.Service;

import com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity.Driver;
import com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity.Ride;
import com.kd.SystemDesign.LLD.Questions.RideSharingService.Strategy.DriverMatchingStrategy;

import java.util.ArrayList;
import java.util.List;

class RideMatchingService {
    private DriverMatchingStrategy matchingStrategy;
    private NotificationService notificationService;
    private List<Driver> availableDrivers;

    public RideMatchingService(DriverMatchingStrategy matchingStrategy,
                               NotificationService notificationService) {
        this.matchingStrategy = matchingStrategy;
        this.notificationService = notificationService;
        this.availableDrivers = new ArrayList<>();
    }

    public void setMatchingStrategy(DriverMatchingStrategy strategy) {
        this.matchingStrategy = strategy;
    }

    public void addDriver(Driver driver) {
        availableDrivers.add(driver);
    }

    public boolean matchRideToDriver(Ride ride) {
        List<Driver> suitableDrivers = matchingStrategy.findSuitableDrivers(ride, availableDrivers);

        if (suitableDrivers.isEmpty()) {
            System.out.println("No suitable drivers found for ride " + ride.getRideId());
            return false;
        }

        // Try to assign ride to drivers in order of preference
        for (Driver driver : suitableDrivers) {
            notificationService.sendRideRequest(driver, ride);

            // Simulate driver response (in real implementation, this would be async)
//            if (simulateDriverResponse(driver)) {
//                assignRideToDriver(ride, driver);
//                return true;
//            }
        }

        System.out.println("No driver accepted ride " + ride.getRideId());
        return false;
    }
}