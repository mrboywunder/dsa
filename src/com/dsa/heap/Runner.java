package com.dsa.heap;

import com.dsa.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.isUgly();
    }

    private void mergeKLists() {
        ListNode a = new ListNode(1);
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(5);
        a1.setNext(a2);
        a.setNext(a1);

        ListNode b = new ListNode(1);
        ListNode b1 = new ListNode(3);
        ListNode b2 = new ListNode(4);
        b1.setNext(b2);
        b.setNext(b1);

        ListNode c = new ListNode(2);
        c.setNext(new ListNode(6));

        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode result = mergeKSortedLists.mergeLists();
        while (result != null) {
            System.out.println(result.getVal());
            result = result.getNext();
        }
    }

    private void isUgly() {
        UglyNumber uglyNumber = new UglyNumber();
        System.out.println(uglyNumber.nthUglyNumber(10));
    }
}
