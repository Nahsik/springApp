package com.kd.SystemDesign.LLD.Questions.ParkingLot.Model;

import com.kd.SystemDesign.LLD.Questions.ParkingLot.ParkingSpace.HeavyWheelerSpace;
import com.kd.SystemDesign.LLD.Questions.ParkingLot.ParkingSpace.ParkingSpaceFactory;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ParkingLot {
    List<Floor> floorList;
    ParkingSpaceFactory pSpaceFact;

    ParkingLot(){
        this.floorList = new ArrayList<>();
        this.pSpaceFact = new ParkingSpaceFactory();
    }

    public void addFloor(Floor f, List<ParkingSpace> p) {
        floorList.add(f);
    }

    public void removeFloor(Floor f) {
    }

    public ParkingSpace findParkingSpace(EntryGate entry, Vehicle v) {
       return new HeavyWheelerSpace();
    }
}
