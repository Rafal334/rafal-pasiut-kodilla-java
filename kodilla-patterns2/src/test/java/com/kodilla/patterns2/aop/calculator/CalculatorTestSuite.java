package com.kodilla.patterns2.aop.calculator;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    private Calculator calculator;
    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorTestSuite.class);

    @Test
    public void testAdd() {
        //Given
        //When
        double result = calculator.add(10, 15);
        //Then
        LOGGER.info("Testing add method");
        assertEquals(25, result, 0);
    }

    @Test
    public void testSub() {
        //Given
        //When
        double result = calculator.sub(10, 15);
        //Then
        LOGGER.info("Testing sub method");
        assertEquals(-5, result, 0);
    }

    @Test
    public void testMul() {
        //Given
        //When
        double result = calculator.mul(10, 15);
        //Then
        LOGGER.info("Testing mul method");
        assertEquals(150, result, 0);
    }

    @Test
    public void testDiv() {
        //Given
        //When
        double result = calculator.div(15, 5);
        //Then
        LOGGER.info("Testing div method");
        assertEquals(3, result, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void shouldThrowArithmeticExceptionDiv() {
        //Given
        //When
        LOGGER.info("Testing div arithmetic exception");
        double result = calculator.div(15, 0);
        //Then
    }

    @Test
    public void testFactorial0() {
        //Given
        //When
        LOGGER.info("Testing factorial: 0");
        BigDecimal result = calculator.factorial(BigDecimal.ZERO);
        //Then
        assertEquals(BigDecimal.ONE, result);
    }

    @Test
    public void testFactorial1() {
        //Given
        //When
        LOGGER.info("Testing factorial: 1");
        BigDecimal result = calculator.factorial(BigDecimal.ONE);
        //Then
        assertEquals(BigDecimal.ONE, result);
    }

    @Test
    public void testFactorial6() {
        //Given
        //When
        LOGGER.info("Testing factorial: 6");
        BigDecimal result = calculator.factorial(new BigDecimal(6));
        //Then
        assertEquals(new BigDecimal(720), result);
    }

    @Test
    public void testBigFactorial() {
        //Given
        //When
        LOGGER.info("Testing factorial: 1000");
        BigDecimal result = calculator.factorial(new BigDecimal(1000));
        //Then
        assertTrue(result.compareTo(BigDecimal.TEN) > 0);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowIllegalStateExceptionFactorial() {
        //Given
        //When
        LOGGER.info("Testing factorial: null Illegal State Exception");
        calculator.factorial(null);
        //Then
    }

    @Test(expected = ArithmeticException.class)
    public void shouldThrowArithmeticExceptionFactorial() {
        //Given
        //When
        LOGGER.info("Testing factorial: -1 Arithmetic exception");
        calculator.factorial(new BigDecimal(-1));
        //Then
    }
}