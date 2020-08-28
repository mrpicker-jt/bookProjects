package com.jt.chapter1_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-08-28 16:58
 **/
public class Ex07 {
    public static void main(String[] args) {
        StdOut.println(mystery("abcdefghijklmn"));
    }

    private static String mystery(String s) {
        int N = s.length();
        if (N <= 1) {
            return s;
        }
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2);
        return mystery(b) + mystery(a);
    }
}
