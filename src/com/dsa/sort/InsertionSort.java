package com.dsa.sort;

public class InsertionSort {

    public void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            while ( i > 0 && key < arr[i-1]) {
                arr[i] = arr[i - 1];
                i --;
            }
            arr[i] = key;
        }
    }
}
