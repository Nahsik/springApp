package com.kd.SystemDesign.LLD.Strategy.Duck.QuackBehavior;

public class Squeak implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
