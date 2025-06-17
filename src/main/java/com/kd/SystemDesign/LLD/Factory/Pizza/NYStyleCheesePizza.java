package com.kd.SystemDesign.LLD.Factory.Pizza;

public class NYStyleCheesePizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("preparing NYStyleCheesePizza");
    }

    @Override
    public void cut() {
        System.out.println("cutting NYStyleCheesePizza");
    }

    @Override
    public void box() {
        System.out.println("packing NYStyleCheesePizza");
    }
}
