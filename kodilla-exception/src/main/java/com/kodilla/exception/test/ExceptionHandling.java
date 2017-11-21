package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {

        SecondChallenge challenge = new SecondChallenge();

        try {
            challenge.probablyIWillThrowException(2, 3);
        } catch (Exception e) {
            System.out.println("New exception");
        } finally {
            System.out.println("Method probablyWillThrowException was called");
        }
    }
}
