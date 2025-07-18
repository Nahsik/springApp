package com.kd.SystemDesign.LLD.Questions.VendingMachine.State;

import com.kd.SystemDesign.LLD.Questions.VendingMachine.VendingMachine;

import java.util.Comparator;

public class ItemSelectedState implements State {

    private VendingMachine vendingMachine;

    public ItemSelectedState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney(int amount) {
       //vendingMachine.set;
    }

    @Override
    public void selectItem(String productCode) {

    }

    @Override
    public void dispense() {

    }
}
