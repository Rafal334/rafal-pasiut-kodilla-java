package com.kodilla.patterns2.decorator.pizza;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        //When
        BigDecimal cost = pizzaOrder.getCost();
        //Then
        Assert.assertEquals(new BigDecimal(20), cost);
    }

    @Test
    public void testBasicPizzaGetIngredients() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        //When
        String ingredients = pizzaOrder.getIngredients();
        //Then
        Assert.assertEquals("Cake souse cheese", ingredients);
    }

    @Test
    public void testPizzaExtraCheeseGetCost() {
        //Given
        PizzaOrder pizzaOrder = new ExtraCheese(new BasicPizzaOrder());
        //When
        BigDecimal cost = pizzaOrder.getCost();
        //Then
        Assert.assertEquals(new BigDecimal(24), cost);
    }

    @Test
    public void testPizzaExtraCheeseGetIngredients() {
        //Given
        PizzaOrder pizzaOrder = new ExtraCheese(new BasicPizzaOrder());
        //When
        String ingredients = pizzaOrder.getIngredients();
        //Then
        Assert.assertEquals("Cake souse cheese extra cheese", ingredients);
    }

    @Test
    public void testPizzaDoubleExtraCheeseGetCost() {
        //Given
        PizzaOrder pizzaOrder = new ExtraCheese(new ExtraCheese(new BasicPizzaOrder()));
        //When
        BigDecimal cost = pizzaOrder.getCost();
        //Then
        Assert.assertEquals(new BigDecimal(28), cost);
    }

    @Test
    public void testPizzaDoubleExtraCheeseGetIngredients() {
        //Given
        PizzaOrder pizzaOrder = new ExtraCheese(new ExtraCheese(new BasicPizzaOrder()));
        //When
        String ingredients = pizzaOrder.getIngredients();
        //Then
        Assert.assertEquals("Cake souse cheese extra cheese extra cheese", ingredients);
    }

    @Test
    public void testPizzaChickenOlivesRucolaGetCost() {
        //Given
        PizzaOrder pizzaOrder = new Rucola(new Olives(new Chicken(new BasicPizzaOrder())));
        //When
        BigDecimal cost = pizzaOrder.getCost();
        //Then
        Assert.assertEquals(new BigDecimal(27), cost);
    }

    @Test
    public void testPizzaChickenOlivesRucolaGetIngredients() {
        //Given
        PizzaOrder pizzaOrder = new Rucola(new Olives(new Chicken(new BasicPizzaOrder())));
        //When
        String ingredients = pizzaOrder.getIngredients();
        //Then
        Assert.assertEquals("Cake souse cheese chicken olives rucola", ingredients);
    }

    @Test
    public void testPizzaOnionHamCornMushroomsGetCost() {
        //Given
        PizzaOrder pizzaOrder = new Onion(new Ham(new Corn(new Mushrooms(new BasicPizzaOrder()))));
        //When
        BigDecimal cost = pizzaOrder.getCost();
        //Then
        Assert.assertEquals(new BigDecimal(29), cost);
    }

    @Test
    public void testPizzaOnionHamCornMushroomsGetIngredients() {
        //Given
        PizzaOrder pizzaOrder = new Onion(new Ham(new Corn(new Mushrooms(new BasicPizzaOrder()))));
        //When
        String ingredients = pizzaOrder.getIngredients();
        //Then
        Assert.assertEquals("Cake souse cheese mushrooms corn ham onion", ingredients);
    }
}
