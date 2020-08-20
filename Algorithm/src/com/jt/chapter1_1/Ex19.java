package com.jt.chapter1_1;

import edu.princeton.cs.algs4.StdOut;

import java.util.stream.IntStream;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-08-19 15:05
 **/
public class Ex19 {
    public static void main(String[] args) {
        IntStream.range(0, 10).forEach(i -> StdOut.println(recursiveFibonacci(i)));
        IntStream.range(0, 10).forEach(i -> StdOut.println(fibonacci(i)));
    }

    private static int recursiveFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    private static int fibonacci(int n) {
        int[] temp = {0, 1};
        if (n == 0) return temp[0];
        if (n == 1) return temp[1];
        for (int i = 2; i <= n; i++) {
            int x = temp[0] + temp[1];
            temp[0] = temp[1];
            temp[1] = x;
        }
        return temp[1];
    }

}
