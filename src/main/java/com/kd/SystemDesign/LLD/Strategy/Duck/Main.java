package com.kd.SystemDesign.LLD.Strategy.Duck;

import com.kd.SystemDesign.LLD.Strategy.Duck.FlyBehavior.FlyNoWay;

public class Main {
    public static void main(String[] args) {
        Duck duck = new ModelDuck();
        duck.display();
        duck.performFly();
        duck.setFlyBehavior(new FlyNoWay());
        duck.performFly();
    }

}
