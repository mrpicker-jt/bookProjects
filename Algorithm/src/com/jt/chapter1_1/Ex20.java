package com.jt.chapter1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-08-19 15:26
 **/
public class Ex20 {
    public static void main(String[] args) {
        StdOut.println(lnFactorial(10));
    }

    private static double lnFactorial(int n) {
        if (n <= 1) return Math.log(1);
        return Math.log(n) + lnFactorial(n - 1);
    }
}
