package com.dsa.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UglyNumber {

    final Heap uglyNumberQueue = new Heap(new ArrayList<Integer>());

    public UglyNumber() {
        this.uglyNumberQueue.insert(1);
    }

    public boolean isUgly(int n) {

        if (n == 1) {
            return true;
        }

        //Is n divisible by 2
        if (n%2 == 0) {
            return isUgly(n/2);
        }
        else if (n % 3 == 0 ) {
            return isUgly(n/3);
        }
        else if (n % 5 == 0){
            return isUgly(n/5);
        }
        else {
            return false;
        }
    }

    public int nthUglyNumber(Integer n) {
        int noOfUglyNumbersComputed = uglyNumberQueue.size();
        for (int i = noOfUglyNumbersComputed + 1; i <= n ; i++) {
            Integer lastUglyNumber = (Integer) uglyNumberQueue.get();
            Integer nextUglyNumber = lastUglyNumber + 1;
            while (!isUgly(nextUglyNumber)) {
                nextUglyNumber = nextUglyNumber + 1;
            }
            uglyNumberQueue.insert(nextUglyNumber);
        }

        return uglyNumberQueue.getTopK(n).get(0);
    }
}
