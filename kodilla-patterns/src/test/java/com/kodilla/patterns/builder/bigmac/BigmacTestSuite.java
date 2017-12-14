package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {

    @Test
    public void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .burgers(2)
                .sauce(Sauce.STANDARD)
                .roll(Roll.WITH_SESAME)
                .ingredients(Ingredients.CHEESE)
                .ingredients(Ingredients.LETTUCE)
                .ingredients(Ingredients.BECON)
                .ingredients(Ingredients.PICKLES)
                .ingredients(Ingredients.ONION)
                .build();
        System.out.println(bigmac);

        //When
        int ingridientsNo = bigmac.getIngredients().size();
        int burgers = bigmac.getBurgers();
        Sauce sauce = bigmac.getSauce();
        Roll roll = bigmac.getRoll();

        //Then
        Assert.assertEquals(5, ingridientsNo);
        Assert.assertEquals(2, burgers);
        Assert.assertEquals(Sauce.STANDARD, sauce);
        Assert.assertEquals(Roll.WITH_SESAME, roll);
    }

    @Test
    public void testBigmacNewDefault() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .build();
        System.out.println(bigmac);

        //When
        int ingridientsNo = bigmac.getIngredients().size();
        int burgers = bigmac.getBurgers();
        Sauce sauce = bigmac.getSauce();
        Roll roll = bigmac.getRoll();

        //Then
        Assert.assertEquals(0, ingridientsNo);
        Assert.assertEquals(1, burgers);
        Assert.assertEquals(Sauce.STANDARD, sauce);
        Assert.assertEquals(Roll.STANDARD, roll);
    }
}
