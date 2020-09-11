package com.jt.chapter1_3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-09-11 13:35
 **/
public class Ex15 {
    public static void main(String[] args) {
        int k = 3;//打印出倒数第k个
        Queue<String> inputs = new Queue<>();
        String[] strings = new String[]{"take", "me", "to", "your", "heart", ",", "take", "me", "to", "your", "soul"};
        Arrays.stream(strings).forEach(inputs::enqueue);
        int size = inputs.size();
        for (int i = 0; i < size - k; i++) {
            inputs.dequeue();
        }
        StdOut.println(inputs.dequeue());
    }
}
