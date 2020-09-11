package com.jt.chapter1_3.intefaces;

public interface SimpleList<T> {
    int size();

    boolean isEmpty();

    void add(T t);

    void add(int index, T t);

    void remove(int index);

    boolean remove(T t);

    T get(int index);
}
