package com.jt.chapter1_4;

import java.util.Arrays;

/**
 * @program: Algorithm
 * @description: 最接近的一对
 * @author: Mrpicker
 * @create: 2020-09-22 15:37
 **/
public class Ex16 {
    public static void main(String[] args) {

    }

    private static double[] findMinGapPair(double[] a) {
        double[] min = new double[2];
        Arrays.sort(a);
        int lo = 0;
        int hi = a.length - 1;
        double minGap = a[hi] - a[lo];
        while (lo < hi) {
            double gap = getAbsGap(a[lo], a[hi]);
            if (gap < minGap) {
                min[0] = a[lo];
                min[1] = a[hi];
                minGap = gap;
                lo++;
                hi--;
            } else {

            }
        }

        return min;
    }

    private static double getAbsGap(double i, double j) {
        return Math.abs(Math.abs(i) - Math.abs(j));
    }

}
