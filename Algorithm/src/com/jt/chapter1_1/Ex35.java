package com.jt.chapter1_1;

import com.jt.util.PrintUtil;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-08-21 17:01
 **/
public class Ex35 {
    public static void main(String[] args) {
        test(10000000, 7);
    }

    private static double[] calculateDiceDistribution(int sides) {
        double[] dist = new double[sides * 2 + 1];
        for (int i = 1; i <= sides; i++) {
            for (int j = 1; j <= sides; j++) {
                dist[i + j] += 1;
            }
        }
        for (int i = 2; i <= sides * 2; i++) {
            dist[i] /= (sides * sides);
        }
        return dist;
    }

    private static int dice(int sides) {
        return (int) (1 + sides * StdRandom.uniform());
    }

    private static void test(int N, int sides) {
        PrintUtil.printDoubleArray(calculateDiceDistribution(sides));
        StdOut.println();
        double[] result = new double[2 * sides + 1];
        for (int i = 0; i < N; i++) {
            int dice1 = dice(sides);
            int dice2 = dice(sides);
            result[dice1 + dice2]++;
        }
        for (int i = 2; i <= sides * 2; i++) {
            result[i] /= N;
        }
        PrintUtil.printDoubleArray(result);
    }

}
