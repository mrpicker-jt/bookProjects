package com.jt.chapter1_4;

import com.jt.util.PrintUtil;

/**
 * @program: Algorithm
 * @description: 最遥远的一对
 * @author: Mrpicker
 * @create: 2020-09-23 13:46
 **/
public class Ex17 {
    public static void main(String[] args) {
        int[] test = {1, 2, 3, 5, 0, -2, -1, -3, -5, 2, 8, 1,};
        PrintUtil.printIntArray(findLongestPairs(test));
    }

    private static int[] findLongestPairs(int[] a) {
        int[] longestPairs = new int[2];
        longestPairs[0] = a[0];
        longestPairs[1] = a[0];
        int maxAbs = Math.abs(a[0]);
        int minAbs = Math.abs(a[0]);
        for (int i = 0; i < a.length; i++) {
            int abs = Math.abs(a[i]);
            if (abs > maxAbs) {
                maxAbs = abs;
                longestPairs[1] = a[i];
            } else if (abs < minAbs) {
                minAbs = abs;
                longestPairs[0] = a[i];
            }
        }
        return longestPairs;
    }
}
