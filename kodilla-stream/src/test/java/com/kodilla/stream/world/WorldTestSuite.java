package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Random;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity() {
        //Given
        BigDecimal count = BigDecimal.ZERO;
        Random rand = new Random();
        World world = new World();
        Continent continent;
        Country country;

        for (int i = 0; i < 8; i++) {
            continent = new Continent();
            for (int j = 0; j < rand.nextInt(100) + 1; j++) {
                country = new Country();
                count = count.add(country.getPeopleQuantity());
                continent.addCountry(country);
            }
            world.addContinent(continent);
        }

        //When
        BigDecimal test;
        test = world.getPeopleQuantity();

        //Than
        Assert.assertEquals(count, test);
    }
}
