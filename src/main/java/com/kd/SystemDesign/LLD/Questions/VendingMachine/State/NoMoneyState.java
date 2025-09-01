package com.kd.SystemDesign.LLD.Questions.VendingMachine.State;

import com.kd.SystemDesign.LLD.Questions.VendingMachine.VendingMachine;

public class NoMoneyState implements State {
    private VendingMachine machine;

    public NoMoneyState(VendingMachine machine) {
        this.machine = machine;
    }

    public void insertMoney(int money) {
        System.out.println("Money inserted.");
        machine.setCurrentBalance(machine.getCurrentBalance() + money);
    }

    public void selectItem(String code) {
        System.out.println("Please insert money first.");
    }

    public void dispense() {
        System.out.println("No money inserted.");
    }
}
