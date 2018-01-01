package com.kodilla.patterns.decorator;

public class DecoratorTester {

    public static void main(String[] args) {
        Screen screen = new YellowLCD(new GreenLCD(new RedLCD(new LCDScreen())));

        screen.blink();
    }
}
