package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ExtraCheese extends AbstractPizzaDecorator {

    public ExtraCheese(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(4));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + " extra cheese";
    }
}
