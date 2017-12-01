package com.company;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {
    static final int SIZE = 10_000_000;
    static int[] array = randomArray();

    private static int[] randomArray() {
        int[] array = new int[SIZE];
        Random random = new Random();

        for (int i = 0; i < SIZE; i++) {
            array[i] = random.nextInt(100);
        }

        return array;
    }

    public static void main(String[] args) {
        int number = 9;

        System.out.println("First 10 elements of the array before: ");

        ArrayTransform mainTask = new ArrayTransform(array, number, 0, SIZE);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);

        System.out.println("First 10 elements of the array after: ");

    }
}
