package com.kd.SystemDesign.LLD.Decorator;

import com.kd.SystemDesign.LLD.Decorator.BasePizza.BasePizza;
import com.kd.SystemDesign.LLD.Decorator.BasePizza.MargheritaPizza;

public class Main {

    public static void main(String[] arg) {
        BasePizza basePizza = new MargheritaPizza();
        BasePizza pizza = new ExtraCheese(basePizza);
        pizza = new MushroomDecorator(pizza);
        System.out.println(pizza.cost());
    }
}
