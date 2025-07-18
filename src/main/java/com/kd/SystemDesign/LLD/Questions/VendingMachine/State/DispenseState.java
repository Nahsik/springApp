package com.kd.SystemDesign.LLD.Questions.VendingMachine.State;

import com.kd.SystemDesign.LLD.Questions.VendingMachine.Product;
import com.kd.SystemDesign.LLD.Questions.VendingMachine.VendingMachine;

public class DispenseState implements State {
    private VendingMachine machine;

    public DispenseState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertMoney(int amount) {
        //
    }

    public void selectItem(String code) {
        System.out.println("Dispensing in progress...");
    }

    public void dispense() {
        Product product = machine.getSelectedProduct();
        System.out.println("Dispensing: " + product.getName());
        machine.setSelectedProduct(null);

        if (machine.getCurrentBalance() > 0) {
            System.out.println("Remaining balance: ₹" + machine.getCurrentBalance());
            machine.setCurrentState(machine.getHasMoneyState());
        } else {
            machine.setCurrentState(machine.getNoMoneyState());
        }
    }
}
