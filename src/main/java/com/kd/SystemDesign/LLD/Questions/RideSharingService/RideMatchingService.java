package com.kd.SystemDesign.LLD.Questions.RideSharingService;

import com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity.Address;
import com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity.Driver;
import com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity.Ride;
import com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity.RideRequest;
import com.kd.SystemDesign.LLD.Questions.RideSharingService.Service.NotificationService;
import com.kd.SystemDesign.LLD.Questions.RideSharingService.Strategy.DriverMatchingStrategy;
import com.kd.SystemDesign.LLD.Questions.RideSharingService.enums.RideStatus;
import com.kd.SystemDesign.LLD.Questions.RideSharingService.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class RideMatchingService {

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
            if (simulateDriverResponse(driver)) {
                assignRideToDriver(ride, driver);
                return true;
            }
        }

        System.out.println("No driver accepted ride " + ride.getRideId());
        return false;
    }

    private boolean simulateDriverResponse(Driver driver) {
        // Simulate driver acceptance based on rating (higher rating = more likely to accept)
        double acceptanceProbability =1 ;// driver.getRating() / 5.0 * 0.8; // Max 80% acceptance
        return Math.random() < acceptanceProbability;
    }

    private void assignRideToDriver(Ride ride, Driver driver) {
        ride.setDriverId(driver.getUserId());
        ride.setRideStatus(RideStatus.DRIVER_ASSIGNED);
        driver.acceptRide(ride);

        System.out.println("Ride " + ride.getRideId() + " assigned to driver " + driver.getName());
    }


}
