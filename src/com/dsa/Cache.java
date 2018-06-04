package com.dsa;

public interface Cache<T> {

    T get(int key);

    T put(int key, int value);

}
