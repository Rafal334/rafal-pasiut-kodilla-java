package com.kodilla.patterns.decorator;

public class RedLCD extends ScreenAccesories {

    public RedLCD(Screen screen) {
        super(screen);
    }
    @Override
    public void blink(){
        super.blink();
        System.out.println("Blinking red");
    }
}
