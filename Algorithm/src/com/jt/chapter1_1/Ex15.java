package com.jt.chapter1_1;

import com.jt.util.PrintUtil;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.stream.IntStream;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-08-19 13:40
 **/
public class Ex15 {
    public static void main(String[] args) {
        int[] ints = IntStream.generate(() -> StdRandom.uniform(10)).limit(10).toArray();
        int[] histogram = histogram(ints, 10);
        PrintUtil.printIntArray(ints);
        PrintUtil.printIntArray(histogram);
    }

    private static int[] histogram(int[] array, int m) {
        int[] M = new int[m];
        for (int i = 0; i < array.length; i++) {
            int i1 = array[i];
            if (i1 >= 0 && i1 < m) {
                M[i1] += 1;
            }
        }
        return M;
    }
}
