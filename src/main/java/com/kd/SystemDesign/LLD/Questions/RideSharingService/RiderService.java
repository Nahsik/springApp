package com.kd.SystemDesign.LLD.Questions.RideSharingService;

import com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity.Address;
import com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity.Ride;
import com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity.RideRequest;

import java.util.List;

public interface RiderService {
    List<Ride> getAllMyRides();
    RideRequest requestNewRide(Address fromAddress,Address toAddress);
    Ride cancelRide(String rideId);
}
