package com.dsa.sort;

public class Runner {

    public static void main(String[] args) {
        int[] arr = new int[]{
                5, 4, 3, 2, 1, 0
        };
        Runner runner = new Runner();
        runner.mergeSort(arr);
    }

    private void insort(int[] arr) {
        InsertionSort insertionSort = new InsertionSort();

        insertionSort.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public void mergeSort(int[] arr) {
        MergeSort mergeSort = new MergeSort();
        int[] retVal = mergeSort.sort(arr, 0, arr.length - 1);
        for (int i = 0; i < retVal.length; i++) {
            System.out.println(i);
        }
    }
}
