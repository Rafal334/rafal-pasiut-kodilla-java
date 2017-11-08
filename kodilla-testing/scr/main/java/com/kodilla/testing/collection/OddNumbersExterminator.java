package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {

    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers){
        ArrayList<Integer> even = new ArrayList<Integer>();
        if(numbers == null){
            return even;
        }
        for(int n : numbers){
            if(n%2==0){
                even.add(n);
            }
        }
        return even;
    }
}
