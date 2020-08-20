package com.jt.chapter1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-08-20 15:58
 **/
public class Ex29 {
    public static void main(String[] args) {
        int[] test = {0, 1, 2, 3, 3, 4, 5, 5, 6, 6, 6, 6, 7, 8, 9, 11, 11, 12};
        StdOut.print(rank(5, test) + count(5, test));
    }

    private static int rank(int key, int a[]) {
        return innerRank(key, a, 0, a.length - 1, 0);
    }

    private static int innerRank(int key, int a[], int lo, int hi, int depth) {
        for (int i = 0; i < depth; i++) {
            StdOut.print(" ");
        }
        StdOut.printf("lo=%d,hi=%d", lo, hi);
        StdOut.println();
        if (lo > hi) {
            return 0;
        }
        if (a[hi] < key) {
            return hi - lo + 1;
        }
        if (a[lo] >= key) {
            return 0;
        }
        int mid = (lo + hi) / 2;
        if (a[mid] >= key) {
            return innerRank(key, a, lo, mid - 1, depth + 1);
        } else {
            return mid - lo + 1 + innerRank(key, a, mid + 1, hi, depth + 1);
        }
    }

    private static int count(int key, int a[]) {
        return innerCount(key, a, 0, a.length - 1, 0);
    }

    private static int innerCount(int key, int a[], int lo, int hi, int depth) {
        for (int i = 0; i < depth; i++) {
            StdOut.print("  ");
        }
        StdOut.printf("lo=%d,hi=%d", lo, hi);
        StdOut.println();
        if (lo > hi) {
            return 0;
        }
        if (a[hi] < key) {
            return 0;
        }
        if (a[lo] > key) {
            return 0;
        }
        int mid = (lo + hi) / 2;
        int tempCount = 0;
        if (a[mid] == key) {
            tempCount = 1;
        }
        if (a[mid] > key) {
            return innerCount(key, a, lo, mid - 1, depth + 1) + tempCount;
        } else {
            return innerCount(key, a, mid + 1, hi, depth + 1) + tempCount;
        }
    }


}
