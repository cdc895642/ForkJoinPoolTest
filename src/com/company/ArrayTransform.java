package com.company;

import java.util.concurrent.RecursiveAction;

public class ArrayTransform extends RecursiveAction {
    int[] array;
    int number;
    int threshold = 20;
    int start;
    int end;

    public ArrayTransform(int[] array, int number, int start, int end) {
        this.array = array;
        this.number = number;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start < threshold) {
            computeDirectly();
        } else {
            int middle = (end + start) / 2;

            ArrayTransform subTask1 = new ArrayTransform(array, number, start, middle);
            ArrayTransform subTask2 = new ArrayTransform(array, number, middle, end);
            System.out.println("before invokeAll");
            invokeAll(subTask1, subTask2);
        }
    }

    private void computeDirectly() {
        System.out.println("computeDirectly");
        for (int i = start; i < end; i++) {
            array[i] = array[i] * number;
            System.out.println(array[i]);
        }
    }
}
