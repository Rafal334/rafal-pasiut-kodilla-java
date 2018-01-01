package com.kodilla.patterns.decorator;

public class LCDScreen implements Screen {

    @Override
    public void blink(){
        System.out.println("basic LCD");
    }
}
