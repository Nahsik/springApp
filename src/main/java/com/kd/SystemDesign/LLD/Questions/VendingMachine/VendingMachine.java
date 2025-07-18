package com.kd.SystemDesign.LLD.Questions.VendingMachine;

import com.kd.SystemDesign.LLD.Questions.ParkingLot.PaymentStrategy;
import com.kd.SystemDesign.LLD.Questions.RideSharingService1.Strategy.Payment;
import com.kd.SystemDesign.LLD.Questions.RideSharingService1.Strategy.UPIPayment;
import com.kd.SystemDesign.LLD.Questions.VendingMachine.Payment.CashPayment;
import com.kd.SystemDesign.LLD.Questions.VendingMachine.State.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendingMachine {
    private final State noMoneyState;
    private final State hasMoneyState;
    private final State itemSelectedState;
    private final State dispenseState;
    private Payment payment;
    private State currentState;
    private Inventory inventory;
    private Product selectedProduct;
    private int currentBalance = 0;

    public VendingMachine() {
        inventory = new Inventory();
        noMoneyState = new NoMoneyState(this);
        hasMoneyState = new HasMoneyState(this);
        itemSelectedState = new ItemSelectedState(this);
        dispenseState = new DispenseState(this);
        currentState = noMoneyState;
        payment = new UPIPayment();
    }





}


