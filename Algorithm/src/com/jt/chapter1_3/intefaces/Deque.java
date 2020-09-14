package com.jt.chapter1_3.intefaces;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-09-14 15:50
 **/
public interface Deque<T> {
    T popLeft();

    T popRight();

    void pushLeft(T item);

    void pushRight(T item);

    boolean isEmpty();

    int size();
}
