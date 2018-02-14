package com.kodilla.patterns2.decorator.taxiportal;


import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class TaxiOrderTestSuite {

    @Test
    public void testBasicTaxiOrderGetCost(){
        //Given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        //When
        BigDecimal cost = taxiOrder.getCost();
        //Then
        Assert.assertEquals(new BigDecimal(5),cost);
    }

    @Test
    public void testBasicTaxiOrderGetDescription(){
        //Given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        //When
        String description = taxiOrder.getDescription();
        //Then
        Assert.assertEquals("Drive a course", description);
    }

    @Test
    public void testTaxiNetworkGetCost(){
        //Given
        TaxiOrder taxiOrder = new TaxiNetworkOrderDecorator(new BasicTaxiOrder());
        //When
        BigDecimal cost = taxiOrder.getCost();
        //Then
        Assert.assertEquals(new BigDecimal(40),cost);
    }

    @Test
    public void testTaxiNetworkGetDescription(){
        //Given
        TaxiOrder taxiOrder = new TaxiNetworkOrderDecorator(new BasicTaxiOrder());
        //When
        String description = taxiOrder.getDescription();
        //Then
        Assert.assertEquals("Drive a course by Taxi Network", description);
    }

    @Test
    public void testUberNetworkGetCost(){
        //Given
        TaxiOrder taxiOrder = new UberNetworkOrderDecorator(new BasicTaxiOrder());
        //When
        BigDecimal cost = taxiOrder.getCost();
        //Then
        Assert.assertEquals(new BigDecimal(25),cost);
    }

    @Test
    public void testUberNetworkGetDescription(){
        //Given
        TaxiOrder taxiOrder = new UberNetworkOrderDecorator(new BasicTaxiOrder());
        //When
        String description = taxiOrder.getDescription();
        //Then
        Assert.assertEquals("Drive a course by Uber Network", description);
    }

    @Test
    public void testMyTaxiGetCost(){
        //Given
        TaxiOrder taxiOrder = new MyTaxiNetworkOrderDecorator(new BasicTaxiOrder());
        //When
        BigDecimal cost = taxiOrder.getCost();
        //Then
        Assert.assertEquals(new BigDecimal(35),cost);
    }

    @Test
    public void testMyTaxiGetDescription(){
        //Given
        TaxiOrder taxiOrder = new MyTaxiNetworkOrderDecorator(new BasicTaxiOrder());
        //When
        String description = taxiOrder.getDescription();
        //Then
        Assert.assertEquals("Drive a course by My Taxi", description);
    }

    @Test
    public void testMyTaxiWithChildSeatGetCost(){
        //Given
        TaxiOrder taxiOrder = new ChildSeatDecorator(new MyTaxiNetworkOrderDecorator(new BasicTaxiOrder()));
        //When
        BigDecimal cost = taxiOrder.getCost();
        //Then
        Assert.assertEquals(new BigDecimal(37),cost);
    }

    @Test
    public void testMyTaxiWithChildSeatGetDescription(){
        //Given
        TaxiOrder taxiOrder = new ChildSeatDecorator(new MyTaxiNetworkOrderDecorator(new BasicTaxiOrder()));
        //When
        String description = taxiOrder.getDescription();
        //Then
        Assert.assertEquals("Drive a course by My Taxi + child seat", description);
    }

    @Test
    public void testMyTaxiWithTwoChildSeatGetCost(){
        //Given
        TaxiOrder taxiOrder = new ChildSeatDecorator(new ChildSeatDecorator(new MyTaxiNetworkOrderDecorator(new BasicTaxiOrder())));
        //When
        BigDecimal cost = taxiOrder.getCost();
        //Then
        Assert.assertEquals(new BigDecimal(39),cost);
    }

    @Test
    public void testMyTaxiWithTwoChildSeatGetDescription(){
        //Given
        TaxiOrder taxiOrder = new ChildSeatDecorator(new ChildSeatDecorator(new MyTaxiNetworkOrderDecorator(new BasicTaxiOrder())));
        //When
        String description = taxiOrder.getDescription();
        //Then
        Assert.assertEquals("Drive a course by My Taxi + child seat + child seat", description);
    }

    @Test
    public void testVipTaxiNetworkWithChildSeatExpressGetCost(){
        //Given
        TaxiOrder taxiOrder = new VipDecorator(new ExpressDecorator(new ChildSeatDecorator(new TaxiNetworkOrderDecorator(new BasicTaxiOrder()))));
        //When
        BigDecimal cost = taxiOrder.getCost();
        //Then
        Assert.assertEquals(new BigDecimal(57), cost);
    }

    @Test
    public void testVipTaxiNetworkWithChildSeatExpressGetDescription(){
        //Given
        TaxiOrder taxiOrder = new VipDecorator(new ExpressDecorator(new ChildSeatDecorator(new TaxiNetworkOrderDecorator(new BasicTaxiOrder()))));
        //When
        String description = taxiOrder.getDescription();
        //Then
        Assert.assertEquals("Drive a course by Taxi Network + child seat express service variant VIP", description);
    }
}
