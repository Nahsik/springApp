package com.kd.SystemDesign.LLD.Strategy.Duck;

import com.kd.SystemDesign.LLD.Strategy.Duck.FlyBehavior.FlyWithWings;
import com.kd.SystemDesign.LLD.Strategy.Duck.QuackBehavior.MuteQuack;

public class ModelDuck extends Duck {

    ModelDuck(){
        flyBehavior = new FlyWithWings();
        quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
