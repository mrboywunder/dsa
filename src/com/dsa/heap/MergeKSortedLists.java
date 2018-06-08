package com.dsa.heap;

import com.dsa.ListNode;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode retVal = new ListNode(-99);
        ListNode head = retVal;

        for (ListNode node : lists) {


        }
        return null;
    }

    public ListNode mergeLists(ListNode a, ListNode b) {
        ListNode retVal = new ListNode();

        while (a != null && b != null) {
            if (a.getVal() < b.getVal()) {
                retVal.setNext(a);
                a = a.getNext();
            }
            else {
                retVal.setNext(b);
                b = b.getNext();
            }
        }

        return null;
    }
}
