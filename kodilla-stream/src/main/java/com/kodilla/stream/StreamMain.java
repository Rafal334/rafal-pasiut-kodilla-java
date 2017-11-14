package com.kodilla.stream;

import com.codilla.stream.lambda.*;
import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {

    public static void main(String[] args) {

        PoemBeautifier beautifier = new PoemBeautifier();

        beautifier.beautify("I want be pretty", (text) -> "ABC"+text+"ABC");
        beautifier.beautify("i want to be big", (text)-> text.toUpperCase());
        beautifier.beautify("I WANT TO BE SMALL", String::toLowerCase); // mozna tak lub jak powyzej
        beautifier.beautify("stars", PoemBeautifier::addStars);

        /*ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);*/
    }
}
