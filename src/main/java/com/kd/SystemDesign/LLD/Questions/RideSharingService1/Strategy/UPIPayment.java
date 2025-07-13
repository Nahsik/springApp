package com.kd.SystemDesign.LLD.Questions.RideSharingService1.Strategy;

public class UPIPayment implements Payment{
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment using UPI for amount: " + amount);
    }
}