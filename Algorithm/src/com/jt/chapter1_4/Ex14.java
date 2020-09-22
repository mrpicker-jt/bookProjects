package com.jt.chapter1_4;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @program: Algorithm
 * @description: sum4
 * @author: Mrpicker
 * @create: 2020-09-21 15:31
 **/
public class Ex14 {
    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, -1, -2, -3, -4};
        StdOut.println(sum4(test));
    }


    private static int sum4(int[] a) {
        Arrays.sort(a);
        int count = 0;
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (BinarySearch.indexOf(a, -a[i] - a[j] - a[k]) > k) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
