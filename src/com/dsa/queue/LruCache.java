package com.dsa.queue;

import com.dsa.ListNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LruCache {

    private int capacity;

    private ListNode head;

    private ListNode tail;

    private final Map<Integer, ListNode> posMap = new HashMap<>();

    public LruCache(int capacity) {
        this.capacity = capacity;
        this.head = new ListNode(-9);
        this.tail = head;
        posMap.put(-9, head);
    }

    public int get(int key) {
        if (posMap.get(key) == null) {
            return -1;
        }
        ListNode requiredNode = posMap.get(key);
        ListNode currentNode = head;
        while (currentNode.getNext().getVal() != key) {
            currentNode = currentNode.getNext();
        }

        currentNode.setNext(requiredNode.getNext());
        requiredNode.setNext(head);
        head = requiredNode;
        return requiredNode.getVal();
    }

    public void put(int key, int value) {
        if (posMap.entrySet().size() <= capacity) {
            final ListNode node = new ListNode(key);
            tail.setNext(node);
            tail = node;
            posMap.put(key, node);
        }
        else {
            
        }
    }
}
