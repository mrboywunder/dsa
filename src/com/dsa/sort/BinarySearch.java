package com.dsa.sort;

public class BinarySearch {

    public int search(int[] arr, int key, int start, int end) {
        int mid = (start + end)/2;
        if (arr[mid] == key) {
            return mid;
        }
        else {
            if (arr[mid] > key) {
                return search(arr, key, start, mid - 1);
            }
            else {
                return search(arr, key, mid + 1, end);
            }
        }
    }
}
