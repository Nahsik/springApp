package com.kd.SystemDesign.LLD.Questions.RideSharingService.Observer;

import com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity.Driver;
import com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity.Ride;

public class InAppNotification implements NotificationObserver {
    @Override
    public void update(String message, Driver driver, Ride ride) {
        System.out.println("In-app notification to driver " + driver.getName() + ": " + message);
    }
}
