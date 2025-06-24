package com.kd.SystemDesign.LLD.State.States;

public interface State {
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
}
