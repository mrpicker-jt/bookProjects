package com.jt.chapter1_4;

import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description: 局部最小元素
 * @author: Mrpicker
 * @create: 2020-09-23 16:44
 **/
public class Ex18 {
    public static void main(String[] args) {
        int[] test = {2, 3, 5, 1, 3, 8, 4, 4, 5, 6};
        int[] test1 = {1, 1, 3, 4, 7, 6, 8, 8, 9, 10};
        StdOut.println(findPartMinIndex(test));
    }

    private static int findPartMinIndex(int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int min = mid;
            if (lo != mid && a[mid - 1] < a[mid]) {
                min = mid - 1;
            }
            if (hi != mid && a[mid + 1] < a[mid]) {
                min = mid + 1;
            }
            if (min == mid) {
                return mid;
            } else if (min == mid - 1) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        return -1;
    }

}
