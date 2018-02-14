package com.kodilla.patterns2.aop.calculator;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@EnableAspectJAutoProxy
@Component
public class Calculator {

    public double add(double x, double y) {
        return x + y;
    }

    public double sub(double x, double y) {
        return x - y;
    }

    public double mul(double x, double y) {
        return x * y;
    }

    public double div(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Divide by zero!");
        } else {
            return x / y;
        }
    }

    public BigDecimal factorial(BigDecimal n) {
        if (n == null) {
            throw new IllegalStateException("Null value in factorial");
        } else if (n.compareTo(BigDecimal.ZERO)<0){
            throw new ArithmeticException("Factorial argument less then zero");
        } else if (n.compareTo(BigDecimal.ONE) <= 0) {
            return BigDecimal.ONE;
        } else {
            return n.multiply(factorial(n.subtract(BigDecimal.ONE)));
        }
    }
}
