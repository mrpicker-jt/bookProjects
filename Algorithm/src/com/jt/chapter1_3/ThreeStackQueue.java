package com.jt.chapter1_3;

import com.jt.chapter1_3.intefaces.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * @program: Algorithm
 * @description: 三个栈组成的队列
 * @author: Mrpicker
 * @create: 2020-09-15 14:13
 **/
public class ThreeStackQueue<T> implements Queue<T> {
    Stack<Stack<Stack>> stackMain;
    Stack<Stack> stackB;
    Stack<T> stackC;

    public ThreeStackQueue() {
        stackMain = new Stack<>();
        stackB = new Stack<>();
        stackC = new Stack<>();
    }


    @Override
    public T deQueue() {
        return null;
    }

    @Override
    public void enQueue(T item) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
