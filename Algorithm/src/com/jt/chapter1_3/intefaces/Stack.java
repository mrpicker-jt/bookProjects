package com.jt.chapter1_3.intefaces;

public interface Stack<T> {
    T pop();

    T peek();

    void push(T item);

    boolean isEmpty();

    int size();

}
