package com.kd.SystemDesign.LLD.Questions.VendingMachine.Payment;

public class UPIPayment implements Payment {
    @Override
    public boolean processPayment(int money) {
        System.out.println("processing UPIPayment " + money);
        return true;
    }
}
