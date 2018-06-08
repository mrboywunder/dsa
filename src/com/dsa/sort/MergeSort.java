package com.dsa.sort;

public class MergeSort {


    public int[] sort(int[] arr, int start, int end) {
        if (start == end) {
            return new int[]{arr[start]};
        }

        int mid = (start + end)/2;
        int[] a = sort(arr, start, mid);
        int[] b = sort(arr, mid + 1, end);
        return merge(a, b);
    }

    private int[] merge(int[] a, int[] b) {
        int[] retVal = new int[a.length + b.length];

        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                retVal[k] = a[i];
                i ++;
            }
            else {
                retVal[k] = b[j];
                j ++;
            }

            k ++;
        }

        if (i == a.length) {
            for (int l = j; l < b.length; l++) {
                retVal[k] = a[l];
                k ++;
            }
        }
        else {
            for (int l = 0; l < a.length; l++) {
                retVal[k] = a[l];
                k ++;
            }
        }

        return retVal;
    }
}
