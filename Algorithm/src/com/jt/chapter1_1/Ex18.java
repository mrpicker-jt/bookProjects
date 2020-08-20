package com.jt.chapter1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-08-19 14:17
 **/
public class Ex18 {
    public static void main(String[] args) {
        int mystery = mystery(3, 27);
//        StdOut.println(mystery);
        StdOut.println(pow(3, 3));
    }

    private static int mystery(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery(a + a, b / 2);
        return mystery(a + a, b / 2) + a;
    }

    private static int pow(int a, int b) {
        if (b == 0) return 1;
        if (b % 2 == 0) return pow(a * a, b / 2);
        return pow(a * a, b / 2) * a;
    }
}
