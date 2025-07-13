package com.kd.SystemDesign.LLD.Questions.RideSharingService.Observer;

import com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity.Driver;
import com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity.Ride;

public interface NotificationObserver {
    void update(String message, Driver driver, Ride ride);
}