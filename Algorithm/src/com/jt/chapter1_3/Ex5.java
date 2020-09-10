package com.jt.chapter1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-09-10 14:45
 **/
public class Ex5 {
    public static void main(String[] args) {
        StdOut.println(convertBase(9, 2));
    }


    private static String convertBase(int num, int base) {
        if (base > 10) {
            throw new IllegalArgumentException();
        }
        Stack<Integer> stack = new Stack<>();
        while (num > 0) {
            stack.push(num % base);
            num /= base;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : stack) {
            stringBuilder.append(integer.toString());
        }
        return stringBuilder.toString();
    }
}
