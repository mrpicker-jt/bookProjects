package com.jt.chapter1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-09-18 15:30
 **/
public class DoublingTest {
    public static void main(String[] args) {
        int N = 100000;
        int[] ints = generateNums(N);
        StopWatch stopWatch = new StopWatch();
        StdOut.println(Ex8.equalSumSlow(ints));
        StdOut.printf("costTime:%.4fs\n", stopWatch.elapseTime() / 1000f);
        StopWatch stopWatch1 = new StopWatch();
        StdOut.println(Ex8.equalSum(ints));
        StdOut.printf("costTime:%.4fs\n", stopWatch1.elapseTime() / 1000f);

    }

    public static int[] generateNums(int N) {
        int digits = String.valueOf(N).length();
        int max = (int) Math.pow(10, digits);
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = StdRandom.uniform(max);
        }
        return array;
    }
}
