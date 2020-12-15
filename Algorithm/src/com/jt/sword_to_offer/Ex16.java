package com.jt.sword_to_offer;

import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description: 数值的整数次方
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * @author: Mrpicker
 * @create: 2020-12-15 19:53
 **/
public class Ex16 {
    public static void main(String[] args) {
        StdOut.println(myPow(2,3));
    }

    private static double myPow(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
