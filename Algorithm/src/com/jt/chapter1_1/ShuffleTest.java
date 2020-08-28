package com.jt.chapter1_1;

import com.jt.util.PrintUtil;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-08-24 12:17
 **/
public class ShuffleTest {
    public static void main(String[] args) {
        shuffle(10, 1000000,false);
        StdOut.println();
        shuffle(10, 1000000,true);
    }

    private static void shuffle(int M, int N ,boolean isBad) {
        int[] array = new int[M];
        int[][] result = new int[M][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < array.length; j++) {
                array[j] = j;
            }
            if (isBad){
                badShuffle(array);
            } else {
                shuffle(array);
            }
            for (int j = 0; j < M; j++) {
                result[j][array[j]]++;
            }
        }
        PrintUtil.printIntArray(result);
    }

    private static void shuffle(int[] a) {
        if (a == null) throw new NullPointerException("argument array is null");
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + StdRandom.uniform(n - i);     // between i and n-1
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    private static void badShuffle(int[] a) {
        if (a == null) throw new NullPointerException("argument array is null");
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r =  StdRandom.uniform(n);     // between 0 and n-1
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
}
