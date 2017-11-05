package com.kodilla.SieveOfErastothenes;

import java.util.ArrayList;

public class SieveOfErastothenes {

    private int[] generateNumbers(int n){
        int[] numbers = new int[n+1];
        for(int i=1;i<=n;i++){
            numbers[i]=i;
        }
        return numbers;
    }

    public ArrayList<Integer> getPrimeNumbers(int n){
        int[] numbers;
        numbers = generateNumbers(n);
        numbers[0]=numbers[1]=0;
        int j;
        for(int i=2;(double)i<Math.sqrt(n);i++){
            j=i*i;
            while(j<=n){
                numbers[j]=0;
                j+=i;
            }
        }
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for(int number : numbers){
            if(number !=0){
                primes.add(number);
            }
        }
        System.out.println(primes.size());
        return primes;
    }
}
