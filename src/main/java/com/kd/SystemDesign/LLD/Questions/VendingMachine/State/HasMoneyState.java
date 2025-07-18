package com.kd.SystemDesign.LLD.Questions.VendingMachine.State;

import com.kd.SystemDesign.LLD.Questions.VendingMachine.VendingMachine;

public class HasMoneyState implements State{
    private  VendingMachine vendingMachine;

    public HasMoneyState(VendingMachine vendingMachine){
     this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney(int amount) {
      //
    }

    @Override
    public void selectItem(String productCode) {

    }

    @Override
    public void dispense() {

    }
}
