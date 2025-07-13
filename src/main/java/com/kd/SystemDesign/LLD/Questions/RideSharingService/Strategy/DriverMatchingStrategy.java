package com.kd.SystemDesign.LLD.Questions.RideSharingService.Strategy;

import com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity.Driver;
import com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity.Ride;

import java.util.List;

public interface DriverMatchingStrategy {
    List<Driver> findSuitableDrivers(Ride ride, List<Driver> availableDrivers);
}
