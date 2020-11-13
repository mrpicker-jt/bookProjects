package com.jt.chapter1_3;

import com.jt.chapter1_3.intefaces.Queue;
import com.jt.chapter1_3.intefaces.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description: 双栈实现的队列
 * @author: Mrpicker
 * @create: 2020-11-09 20:30
 **/
public class TwoStackQueue<T> implements Queue<T> {

    Stack<T> stackA;
    Stack<T> stackB;

    public TwoStackQueue() {
        stackA = new LinkStack<>();
        stackB = new LinkStack<>();
    }

    public static void main(String[] args) {
        TwoStackQueue<String> twoStackQueue = new TwoStackQueue<>();
        twoStackQueue.enQueue("Hi ");
        twoStackQueue.enQueue("I ");
        twoStackQueue.enQueue("am ");
        twoStackQueue.enQueue("jt");
        while (!twoStackQueue.isEmpty()) {
            StdOut.print(twoStackQueue.deQueue());
        }
    }

    @Override
    public T deQueue() {
        if (stackB.isEmpty()) {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }
        return stackB.pop();
    }

    @Override
    public void enQueue(T item) {
        stackA.push(item);
    }

    @Override
    public boolean isEmpty() {
        return stackA.isEmpty() & stackB.isEmpty();
    }

    @Override
    public int size() {
        return stackA.size() + stackB.size();
    }
}
