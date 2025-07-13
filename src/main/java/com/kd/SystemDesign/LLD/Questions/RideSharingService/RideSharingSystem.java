package com.kd.SystemDesign.LLD.Questions.RideSharingService;

import com.kd.SystemDesign.LLD.Questions.ParkingLot.Model.Vehicle;
import com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity.Address;
import com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity.Driver;
import com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity.Ride;
import com.kd.SystemDesign.LLD.Questions.RideSharingService.Observer.InAppNotification;
import com.kd.SystemDesign.LLD.Questions.RideSharingService.Observer.NotificationObserver;
import com.kd.SystemDesign.LLD.Questions.RideSharingService.Observer.PushNotification;
import com.kd.SystemDesign.LLD.Questions.RideSharingService.Observer.SMSNotification;
import com.kd.SystemDesign.LLD.Questions.RideSharingService.Service.NotificationService;
import com.kd.SystemDesign.LLD.Questions.RideSharingService.Strategy.NearestDriverStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class RideSharingSystem {
    public static void main(String[] args) {
        // Create notification service with observers
        NotificationService notificationService = new NotificationService();
        notificationService.addObserver(new SMSNotification());
        notificationService.addObserver(new PushNotification());
        notificationService.addObserver(new InAppNotification());

        // Create drivers
        List<Driver> drivers = createSampleDrivers();

        // Create ride matching service with different strategies
        RideMatchingService matchingService = new RideMatchingService(
                new NearestDriverStrategy(), notificationService);

        // Add drivers to the service
        drivers.forEach(matchingService::addDriver);

//        // Create sample rides
//        Ride ride1 = createSampleRide("R001", "Downtown", "Airport", RideType.REGULAR);
//        Ride ride2 = createSampleRide("R002", "Mall", "Hotel", RideType.PREMIUM);
//        Ride ride3 = createSampleRide("R003", "Station", "Office", RideType.XL);
//
//        System.out.println("=== Testing Nearest Driver Strategy ===");
//        matchingService.matchRideToDriver(ride1);
//
//        System.out.println("\n=== Testing Highest Rated Driver Strategy ===");
//        matchingService.setMatchingStrategy(new HighestRatedDriverStrategy());
//        matchingService.matchRideToDriver(ride2);
//
//        System.out.println("\n=== Testing Balanced Driver Strategy ===");
//        matchingService.setMatchingStrategy(new BalancedDriverStrategy());
//        matchingService.matchRideToDriver(ride3);
//
//        System.out.println("\n=== Testing Vehicle Type Strategy ===");
//        matchingService.setMatchingStrategy(new VehicleTypeStrategy());
//        Ride luxuryRide = createSampleRide("R004", "Hotel", "Restaurant", RideType.PREMIUM);
//        matchingService.matchRideToDriver(luxuryRide);
    }

    private static List<Driver> createSampleDrivers() {
        List<Driver> drivers = new ArrayList<>();

//        // Driver 1 - Nearest
//        Vehicle vehicle1 = new Vehicle("V001", "Toyota", "Camry", "2020", "ABC123", VehicleType.SEDAN, 4);
//        Driver driver1 = new Driver("D001", "John Smith", "+1234567890", "L001", vehicle1,
//                new Location(12.9716, 77.5946, "Downtown"));
//        driver1.setRating(4.5);
//        driver1.goOnline();
//        drivers.add(driver1);
//
//        // Driver 2 - Highest rated
//        Vehicle vehicle2 = new Vehicle("V002", "BMW", "X5", "2021", "XYZ456", VehicleType.LUXURY, 5);
//        Driver driver2 = new Driver("D002", "Sarah Johnson", "+1234567891", "L002", vehicle2,
//                new Location(12.9800, 77.6000, "Uptown"));
//        driver2.setRating(4.9);
//        driver2.goOnline();
//        drivers.add(driver2);
//
//        // Driver 3 - SUV for XL rides
//        Vehicle vehicle3 = new Vehicle("V003", "Ford", "Explorer", "2019", "SUV789", VehicleType.SUV, 7);
//        Driver driver3 = new Driver("D003", "Mike Davis", "+1234567892", "L003", vehicle3,
//                new Location(12.9500, 77.5800, "Midtown"));
//        driver3.setRating(4.2);
//        driver3.goOnline();
//        drivers.add(driver3);

        return drivers;
    }

    private static Ride createSampleRide(String rideId, String pickup, String destination, Ride type) {
        Address pickupLoc = new Address(12.9716, 77.5946);
        Address destLoc = new Address(12.9800, 77.6000);
        return new Ride(rideId, "R001", pickupLoc, destLoc);
    }
}
