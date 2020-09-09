package com.jt.chapter1_3.intefaces;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-09-09 16:38
 **/
public interface Queue<T> {
    T deQueue();

    void enQueue(T item);

    boolean isEmpty();

    int size();
}
