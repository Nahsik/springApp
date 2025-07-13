package com.kd.SystemDesign.LLD.Questions.RideSharingService1.Strategy;

import com.kd.SystemDesign.LLD.Questions.RideSharingService1.Entity.Driver;
import com.kd.SystemDesign.LLD.Questions.RideSharingService1.Entity.Location;

import java.util.List;

public interface FindDriverStrategy {
    List<Driver> findDrivers(List<Driver> driver, Location droupLocation);
}
