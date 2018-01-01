package com.kodilla.patterns.decorator;

public class YellowLCD extends ScreenAccesories {

    public YellowLCD(Screen screen) {
        super(screen);
    }

    @Override
    public void blink(){
        super.blink();
        System.out.println("YellowBlinking");
    }
}
