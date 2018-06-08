package com.dsa.heap;

import com.dsa.ListNode;

public class MergeKSortedLists {

    public ListNode mergeLists(ListNode... lists){
        ListNode currentNode = new ListNode(-99999);
        ListNode head = currentNode;
        ListNode[] headers = new ListNode[lists.length];

        System.arraycopy(lists, 0, headers, 0, lists.length);

        while (this.findMin(headers) != -1) {
            int minHeaderIndex = this.findMin(headers);
            ListNode minNode = headers[minHeaderIndex];
            currentNode.setNext(minNode);
            currentNode = currentNode.getNext();
            minNode = minNode.getNext();
            headers[minHeaderIndex] = minNode;
        }

        return head.getNext();
    }

    public int findMin(ListNode[] arr) {
        if (arr.length == 0) {
            return -1;
        }
        ListNode min = arr[0];
        int minIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            ListNode node = arr[i];
            if (node == null) {
                continue;
            }
            if (min == null) {
                min = node;
                minIndex = i;
            }
            else if (node.getVal() < min.getVal()) {
                min = node;
                minIndex = i;
            }
        }

        if (min == null) {
            minIndex = -1;
        }

        return minIndex;
    }


}
