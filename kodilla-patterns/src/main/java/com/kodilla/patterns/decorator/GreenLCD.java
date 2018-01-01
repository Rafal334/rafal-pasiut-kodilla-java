package com.kodilla.patterns.decorator;

public class GreenLCD extends ScreenAccesories {

    public GreenLCD(Screen screen) {
        super(screen);
    }
    @Override
    public void blink(){
        super.blink();
        System.out.println("GREEN blnking");
    }
}
