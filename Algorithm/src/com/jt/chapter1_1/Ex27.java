package com.jt.chapter1_1;

import com.jt.util.PrintUtil;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-08-20 15:01
 **/
public class Ex27 {
    private static long COUNT = 0;
    private static long COUNT2 = 0;
    private static double[][] MATRIX;

    public static void main(String[] args) {
//        System.out.println("result: " + binomial(10, 5, 0.25) + ", count: " + COUNT);
        System.out.println("result: " + betterBinomial(10, 4, 0.25) + ", count: " + COUNT2);
        PrintUtil.printDoubleArray(MATRIX);
    }

    private static double binomial(int n, int k, double p) {
        COUNT++;
        if (n == 0 && k == 0) return 1.0;
        if (n < 0 || k < 0) return 0.0;
        return (1.0 - p) * binomial(n - 1, k, p) + p * binomial(n - 1, k - 1, p);
    }

    private static double betterBinomial(int n, int k, double p) {
        MATRIX = new double[n + 1][k + 1];
        for (int i = 0; i < MATRIX.length; i++) {
            for (int j = 0; j < MATRIX[i].length; j++) {
                MATRIX[i][j] = -1;
            }
        }
        return bin(MATRIX, n, k, p);
    }

    private static double bin(double[][] array, int n, int k, double p) {
        COUNT2++;
        if (n == 0 && k == 0) return 1.0;
        if (n < 0 || k < 0) return 0.0;
        if (array[n][k] == -1) {
            array[n][k] = (1.0 - p) * bin(array, n - 1, k, p) + p * bin(array, n - 1, k - 1, p);
        }
        return array[n][k];
    }
}
