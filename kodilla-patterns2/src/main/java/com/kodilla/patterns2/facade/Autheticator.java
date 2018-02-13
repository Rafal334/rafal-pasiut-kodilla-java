package com.kodilla.patterns2.facade;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class Autheticator {

    public boolean isAuthenticatetd(Long userId){
        return new Random().nextBoolean();
    }
}
