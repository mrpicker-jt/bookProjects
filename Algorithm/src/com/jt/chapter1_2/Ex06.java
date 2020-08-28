package com.jt.chapter1_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-08-28 16:37
 **/
public class Ex06 {

    public static void main(String[] args) {
        StdOut.println(isCircularRotation2("abcdefghijklmn", "mnabcdefghijkl"));
    }

    private static boolean isCircularRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            String prefix = s1.substring(0, i + 1);
            String suffix = s1.substring(i + 1);
            String newStr = suffix + prefix;
            if (newStr.equals(s2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCircularRotation2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return s1.concat(s1).contains(s2);
    }
}
