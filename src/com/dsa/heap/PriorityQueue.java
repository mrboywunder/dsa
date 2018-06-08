package com.dsa.heap;

public interface PriorityQueue<T> {

    PriorityQueue create();

    boolean empty();

    void insert(T t);

    T get();

    void remove(T t);
}
