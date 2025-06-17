package com.kd.SystemDesign.LLD.Factory;

import com.kd.SystemDesign.LLD.Factory.Pizza.Pizza;

public abstract class PizzaStore {
    abstract protected Pizza createPizza(String type);

    Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
