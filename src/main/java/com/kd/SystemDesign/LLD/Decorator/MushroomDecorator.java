package com.kd.SystemDesign.LLD.Decorator;

import com.kd.SystemDesign.LLD.Decorator.BasePizza.BasePizza;
import com.kd.SystemDesign.LLD.Decorator.BasePizza.MargheritaPizza;

public class MushroomDecorator extends ToppingDecorator {
    BasePizza basePizza;

    MushroomDecorator(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return 30 + this.basePizza.cost();
    }
}
