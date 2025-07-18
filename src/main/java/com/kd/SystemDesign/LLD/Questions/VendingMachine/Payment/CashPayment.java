package com.kd.SystemDesign.LLD.Questions.VendingMachine.Payment;

public class CashPayment implements Payment {
    @Override
    public boolean processPayment(int money) {
        System.out.println("Processing CashPayment" + money);
        return true;
    }
}
