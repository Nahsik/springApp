package com.kd.SystemDesign.LLD.Decorator;

import com.kd.SystemDesign.LLD.Decorator.BasePizza.BasePizza;

public class  ExtraCheese extends ToppingDecorator {
    BasePizza basePizza;

    ExtraCheese(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return basePizza.cost() + 50;
    }
}
