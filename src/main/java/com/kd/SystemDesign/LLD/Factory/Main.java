package com.kd.SystemDesign.LLD.Factory;

public class Main {
    public static void main(String[] args){
        PizzaStore pizzaStore = new NYPizzaStore();
        pizzaStore.orderPizza("cheese");
    }
}
