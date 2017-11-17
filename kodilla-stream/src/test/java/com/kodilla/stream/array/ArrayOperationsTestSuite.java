package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage() {
        //Given
        Random rand = new Random();
        double mean, sum = 0;

        int[] numbers = IntStream.rangeClosed(0, 1000).map(n -> rand.nextInt(100)).toArray();
        for (int n : numbers) {
            sum += n;
        }
        mean = sum / numbers.length;

        //When
        double result = ArrayOperations.getAverage(numbers);

        //Than
        Assert.assertEquals(mean, result, 0);
    }
}
