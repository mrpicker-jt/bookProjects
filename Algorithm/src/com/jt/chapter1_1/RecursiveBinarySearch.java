package com.jt.chapter1_1;

import java.util.List;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-08-19 15:46
 **/
public class RecursiveBinarySearch {
    public static int search(int key, int[] a) {
        return recursiveSearch(key, 0, a.length - 1, a);
    }

    private static int recursiveSearch(int key, int lo, int hi, int[] a) {
        if (lo > hi) return -1;
        int mid = (lo + hi) / 2;
        int midInt = a[mid];
        if (key == midInt) return mid;
        if (key > midInt) {
            return recursiveSearch(key, mid + 1, hi, a);
        } else {
            return recursiveSearch(key, lo, mid - 1, a);
        }
    }
}
