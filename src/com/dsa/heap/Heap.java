package com.dsa.heap;

import com.dsa.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Heap implements PriorityQueue{

    private List<Integer> arr;

    public Heap(List<Integer> arr) {
        this.arr = arr;
        this.create();
    }

    private void heapify(int at, int heapsize) {

        if (at > heapsize) {
            return;
        }

        Integer node = this.arr.get(at);
        Integer leftIndex = 2 * at + 1;
        Integer rightIndex = 2 * at + 2;

        Integer largest = node;
        Integer indexOfLargestNode = at;

        if (leftIndex < heapsize && largest < arr.get(leftIndex)) {
            indexOfLargestNode = 2*at + 1;
            largest = arr.get(leftIndex);
        }
        if (rightIndex < heapsize && largest < arr.get(rightIndex)) {
            indexOfLargestNode = 2*at + 2;
            largest = arr.get(rightIndex);
        }

        if (indexOfLargestNode != at) {
            arr.set(indexOfLargestNode, node);
            arr.set(at, largest);
            heapify(indexOfLargestNode, heapsize);
        }

    }

    public int size() {
        return this.arr.size();
    }

    @Override
    public PriorityQueue create() {
        int heapsize = arr.size();

        for (int i = heapsize/2 - 1; i >= 0; i--) {
            this.heapify(i, heapsize);
        }

        return null;
    }

    @Override
    public boolean empty() {
        return this.arr.isEmpty();
    }

    @Override
    public void insert(Object o) {
        this.arr.add((Integer) o);
        this.create();
    }

    @Override
    public Object get() {
        return this.arr.get(0);
    }

    public List<Integer> getTopK(int k) {
        List<Integer> retVal = new ArrayList<>();
        for (int i = 0; i < k ; i++) {
            retVal.add(this.arr.get(i));
        }
        return retVal;
    }

    private void buildMaxHeap(int heapsize) {
        for (int i = heapsize/2; i >= 0; i--) {
            this.heapify(i, heapsize);
        }
    }

    @Override
    public void remove(Object o) {
        Integer index = this.arr.indexOf((Integer) o);
        this.arr.set(index, -9999);
        this.create();
        this.arr.remove(arr.size() - 1);
    }

    public void sort() {
        for (int i = arr.size(); i > 0 ; i--) {
            int temp = arr.get(i - 1);
            this.arr.set(i - 1, arr.get(0));
            this.arr.set(0, temp);
            this.buildMaxHeap(i - 1);
        }
    }
}
