package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers) {

        IntStream.range(0, numbers.length).map(i -> numbers[i]).forEach(System.out::println);   // lub Arrays.stream(numbers).forEach(System.out::println);

        return IntStream.range(0, numbers.length).map(i -> numbers[i]).average().getAsDouble();  // lub Arrays.stream(numbers).average().getAsDouble();
    }
}
