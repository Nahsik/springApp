package com.kd.SystemDesign.LLD.Decorator;

import com.kd.SystemDesign.LLD.Decorator.BasePizza.BasePizza;

public class ToppingDecorator extends BasePizza {

    @Override
    public int cost() {
        return 0;
    }
}
