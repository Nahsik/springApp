package com.kd.SystemDesign.LLD.Strategy.Duck;

import com.kd.SystemDesign.LLD.Strategy.Duck.FlyBehavior.FlyBehavior;
import com.kd.SystemDesign.LLD.Strategy.Duck.QuackBehavior.QuackBehavior;

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() {
    }

    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }


    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }
}