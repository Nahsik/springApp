package com.kd.SystemDesign.LLD.Questions.ParkingLot.Model;

import com.kd.SystemDesign.LLD.Questions.ParkingLot.Enums.VehicleType;
import lombok.Data;

@Data
public class Vehicle {
    int regNum;
    VehicleType vehicleType;
}
