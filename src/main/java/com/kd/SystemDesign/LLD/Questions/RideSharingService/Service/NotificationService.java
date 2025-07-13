package com.kd.SystemDesign.LLD.Questions.RideSharingService.Service;

import com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity.Driver;
import com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity.Ride;
import com.kd.SystemDesign.LLD.Questions.RideSharingService.Observer.NotificationObserver;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private List<NotificationObserver> observers = new ArrayList<>();

    public void addObserver(NotificationObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(NotificationObserver observer) {
        observers.remove(observer);
    }

    public void notifyDriver(Driver driver, Ride ride, String message) {
        for (NotificationObserver observer : observers) {
            observer.update(message, driver, ride);
        }
    }

    public void sendRideRequest(Driver driver, Ride ride) {
        String message = "New ride request from " + ride.getPickUpAddress() +
                " to " + ride.getDropAddress() +
                ". Estimated fare: $" + ride.getEstimatedFare();
        notifyDriver(driver, ride, message);
    }
}
