package com.jt.chapter1_2;

import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-08-28 15:29
 **/
public class Ex02 {
    public static void main(String[] args) {
        int N = 10;
        int max = 1000;


        Interval[] intervals = new Interval[N];
        for (int i = 0; i < N; i++) {
            double v1 = StdRandom.uniform(max);
            double v2 = StdRandom.uniform(max);
            intervals[i] = new Interval(Math.min(v1, v2), Math.max(v1, v2));
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                Interval interval1 = intervals[i];
                Interval interval2 = intervals[j];
                if (interval1.isInterSect(interval2)) {
                    StdOut.printf("%s--%s", interval1.toString(), interval2.toString());
                    StdOut.println();
                }
            }
        }

    }
}
