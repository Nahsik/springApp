package com.kd.SystemDesign.LLD.State;

import com.kd.SystemDesign.LLD.State.States.*;
import lombok.Getter;
import lombok.Setter;

@Getter
public class GumballMachine {

    private final State soldOutState;
    private final State noQuarterState;
    private final State hasQuarterState;
    private final State soldState;

    @Setter
    State state;

    private int count = 0;


    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count > 0) {
            count--;
        }
    }

}
