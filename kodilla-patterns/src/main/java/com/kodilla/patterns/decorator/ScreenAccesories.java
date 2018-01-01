package com.kodilla.patterns.decorator;

public class ScreenAccesories implements Screen{

    private Screen screen;

    public ScreenAccesories(Screen screen) {
        this.screen = screen;
    }

    @Override
    public void blink() {
        screen.blink();
    }
}
