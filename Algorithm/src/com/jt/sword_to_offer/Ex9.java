package com.jt.sword_to_offer;

import com.jt.chapter1_3.TwoStackQueue;
import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description: 两个栈实现一个队列
 * @author: Mrpicker
 * @create: 2020-11-13 20:25
 **/
public class Ex9 {
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
}
