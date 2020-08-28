package com.jt.chapter1_2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-08-24 15:20
 **/
public class VisualAccumulator extends Accumulator {
    public VisualAccumulator(int trials, double max) {
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(.01);
    }

    public static void main(String[] args) {
        int N = 1000;
        int max = 10;
        VisualAccumulator visualAccumulator = new VisualAccumulator(N, max);
        for (int i = 0; i < N; i++) {
            visualAccumulator.addDataValue(StdRandom.uniform() * max);
        }
        StdOut.println(visualAccumulator);
    }

    @Override
    public void addDataValue(double val) {
        N++;
        total += val;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(N, val);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(N, mean());
    }
}
