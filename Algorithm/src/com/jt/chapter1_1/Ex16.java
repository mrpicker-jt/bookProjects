package com.jt.chapter1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-08-19 14:07
 **/
public class Ex16 {
    public static void main(String[] args) {
        StdOut.println(exRl(7));
    }

    private static String exRl(int n) {
        if (n <= 0) return "";
        return exRl(n - 3) + n + exRl(n - 2) + n;
    }
}
