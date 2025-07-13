package com.kd.SystemDesign.LLD.Questions.RideSharingService1;

import com.kd.SystemDesign.LLD.Questions.RideSharingService1.Entity.*;
import com.kd.SystemDesign.LLD.Questions.RideSharingService1.Enums.DriverStatus;
import com.kd.SystemDesign.LLD.Questions.RideSharingService1.Enums.PaymentStatus;
import com.kd.SystemDesign.LLD.Questions.RideSharingService1.Enums.RideStatus;
import com.kd.SystemDesign.LLD.Questions.RideSharingService1.Strategy.*;
import com.kd.SystemDesign.LLD.Questions.RideSharingService1.Strategy.BasicFairCalculation;
import com.kd.SystemDesign.LLD.Questions.RideSharingService1.Strategy.FairCalculationStrategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RideSharingService {
    private Map<String, Driver> driverMap;
    public Map<String, Rider> riderMap;
    private Map<String, Ride> rideMap;
    private FindDriverStrategy driverMatchingStrategy;
    private FairCalculationStrategy fairCalculationStrategy;
    private static RideSharingService instance;

    private RideSharingService() {
        driverMap = new ConcurrentHashMap<>();
        rideMap = new ConcurrentHashMap<>();
        riderMap = new ConcurrentHashMap<>();
        driverMatchingStrategy = new NearestFirstStrategy();
        fairCalculationStrategy = new BasicFairCalculation();
    }

    public static synchronized RideSharingService getInstance() {
        if (instance == null) {
            instance = new RideSharingService();
        }
        return instance;
    }

    public Driver registerDriver(String name, String contact, String licensePlate, Location location) {
        Driver driver = new Driver(name, contact, licensePlate, location);
        driverMap.put(driver.getId(), driver);
        return driver;
    }

    public Rider registerRider(String name, String contact) {
        Rider rider = new Rider(name, contact);
        riderMap.put(rider.getId(), rider);
        return rider;
    }

    public synchronized Ride requestRide(String riderId, Location from, Location to) {
        Rider rider = riderMap.get(riderId);
        if (rider == null) throw new IllegalArgumentException("Rider not found");

        Ride trip = new Ride(rider, from, to);

        notifyNearbyDrivers(trip);

        rideMap.put(trip.getId(), trip);
        return trip;
    }

    private void notifyNearbyDrivers(Ride ride) {
        boolean foundNearbyAvailableDriver = false;
        for (Driver driver : driverMatchingStrategy.findDrivers(
                driverMap.values().stream().toList(), ride.getDroupLocation())) {
            System.out.println("Notifying driver: " + driver.getName() + " about ride request: " + ride.getId());
        }

        if (!foundNearbyAvailableDriver) {
            throw new IllegalStateException("No available drivers");
        }
    }


    public void acceptRide(String driverId, String tripId) {
        Driver driver = driverMap.get(driverId);
        Ride trip = rideMap.get(tripId);
        if (trip.getStatus() == RideStatus.REQUESTED) {
            Rider rider = trip.getRider();
            trip.setDriver(driver);
            trip.setStatus(RideStatus.ACCEPTED);
            driver.setDriverStatus(DriverStatus.IN_RIDE);
            rider.assignTrip(trip);
            System.out.printf("Trip started: %s (Driver: %s -> Rider: %s)%n",
                    trip.getId(), driver.getName(), rider.getName());
            notifyRider(trip);
        }
    }

    public void startRide(String tripId) {
        Ride trip = rideMap.get(tripId);
        if (trip.getStatus() == RideStatus.ACCEPTED) {
            trip.setStatus(RideStatus.ONGOING);
            notifyRider(trip);
        }
    }

    public synchronized void completeRide(String tripId) {
        Ride trip = rideMap.get(tripId);
        if (trip.getStatus() == RideStatus.ONGOING) {
            trip.setStatus(RideStatus.COMPLETED);
            trip.getDriver().setDriverStatus(DriverStatus.AVAILABLE);
            trip.getRider().completeTrip();

            double fare = fairCalculationStrategy.calculateFair(trip.getPickUpLocation(), trip.getDroupLocation());
            trip.setFare(fare);

            notifyRider(trip);
            notifyDriver(trip);
            System.out.printf("Trip %s completed%n", trip.getId());
        }
    }

    public void cancelRide(String tripId) {
        Ride trip = rideMap.get(tripId);
        if (trip.getStatus() == RideStatus.REQUESTED || trip.getStatus() == RideStatus.ACCEPTED) {
            trip.setStatus(RideStatus.CANCELLED);
            if (trip.getDriver() != null) {
                trip.getDriver().setDriverStatus(DriverStatus.AVAILABLE);
            }
            notifyDriver(trip);
        }
    }

    public void makePayment(String tripId, Payment payment) {
        Ride trip = rideMap.get(tripId);
        double fare = trip.getFare();
        payment.processPayment(fare);
        trip.setPaymentStatus(PaymentStatus.DONE);
    }

    private void notifyRider(Ride trip) {
        // Notify the passenger about ride status updates
        // ...
        User user = trip.getRider();
        String message = switch (trip.getStatus()) {
            case ACCEPTED -> "Your ride has been accepted by driver: " + trip.getDriver().getName();
            case ONGOING -> "Your ride is in progress";
            case COMPLETED -> "Your ride has been completed. Fare: $" + trip.getFare();
            case CANCELLED -> "Your ride has been cancelled";
            default -> "";
        };
        // Send notification to the passenger
        System.out.println("Notifying rider: " + user.getName() + " - " + message);
    }

    private void notifyDriver(Ride trip) {
        Driver driver = trip.getDriver();
        if (driver != null) {
            String message = switch (trip.getStatus()) {
                case COMPLETED -> "Ride completed. Fare: $" + trip.getFare();
                case CANCELLED -> "Ride cancelled by passenger";
                default -> "";
            };
            // Send notification to the driver
            System.out.println("Notifying driver: " + driver.getName() + " - " + message);
        }
    }
}
