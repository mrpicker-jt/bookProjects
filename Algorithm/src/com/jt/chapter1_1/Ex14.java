package com.jt.chapter1_1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Random;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-08-19 10:59
 **/
public class Ex14 {
    public static void main(String[] args) {
        Random random = new Random();
        random.ints().filter(i -> i > 0).limit(10).forEach(i -> {
            StdOut.printf("%d    ", i);
            StdOut.printf("  lg: %d", lg(i));
            StdOut.printf("  Math: %d", (int) (Math.log(i) / Math.log(2)));
            StdOut.println();
        });
        StdOut.println(lg(1));
    }

    private static int lg(int n) {
        int count = 0;
        while (n > 1) {
            n = n / 2;
            count++;
        }
        return count;
    }
}
