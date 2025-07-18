package com.kd.SystemDesign.LLD.Questions.VendingMachine.Payment;

public class CardPayment implements Payment {
    @Override
    public boolean processPayment(int money) {
        System.out.println("Processing CardPayment:" + money);
        return true;
    }
}
