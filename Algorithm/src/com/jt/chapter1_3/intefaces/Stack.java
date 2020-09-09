package com.jt.chapter1_3.intefaces;

public interface Stack<T> {
    T pop();

    void push(T item);

    boolean isEmpty();

    int size();

}
