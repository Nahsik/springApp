package com.kd.SystemDesign.LLD.Questions.VendingMachine.State;

public interface State {
    void insertMoney(int amount);
    void selectItem(String productCode);
    void dispense();
}
