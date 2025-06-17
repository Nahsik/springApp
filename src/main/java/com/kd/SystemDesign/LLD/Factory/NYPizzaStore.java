package com.kd.SystemDesign.LLD.Factory;

import com.kd.SystemDesign.LLD.Factory.Pizza.NYStyleCheesePizza;
import com.kd.SystemDesign.LLD.Factory.Pizza.Pizza;

public class NYPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        if(type.equals("cheese")){
            return new NYStyleCheesePizza();
        }else {
            return null;
        }
    }

}
