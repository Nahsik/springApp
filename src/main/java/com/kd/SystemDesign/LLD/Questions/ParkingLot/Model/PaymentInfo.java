package com.kd.SystemDesign.LLD.Questions.ParkingLot.Model;

import com.kd.SystemDesign.LLD.Questions.ParkingLot.Enums.PaymentType;
import com.kd.SystemDesign.LLD.Questions.ParkingLot.PaymentStrategy;

import java.util.Date;

public class PaymentInfo {
    int paymentId;
    double amount;
    Date date;
    PaymentType paymentType;
    PaymentStrategy paymentStrategy;
}
