package com.jt.chapter1_1;

import com.jt.util.PrintUtil;
import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-08-21 16:00
 **/
public class Matrix {

    public static void main(String[] args) {
        double[][] a = {{1, 2, 3}, {3, 2, 1}};
        double[][] b = {{0, 3}, {2, 3}, {1, 3}};
        double[] x = {2, 0, 1};
        StdOut.println("a--------------------");
        PrintUtil.printDoubleArray(a);
        StdOut.println();
        StdOut.println("b--------------------");
        PrintUtil.printDoubleArray(b);
        StdOut.println();
        StdOut.println("x--------------------");
        PrintUtil.printDoubleArray(x);
        StdOut.println();
        StdOut.println("a*b--------------------");
        PrintUtil.printDoubleArray(mult(a, b));
        StdOut.println();
        StdOut.println("a transpose--------------------");
        PrintUtil.printDoubleArray(transpose(a));
        StdOut.println();
        StdOut.println("a*x--------------------");
        PrintUtil.printDoubleArray(mult(a, x));
        StdOut.println();
        StdOut.println("x*b--------------------");
        PrintUtil.printDoubleArray(mult(x, b));
    }

    public static double dot(double[] x, double[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("Length must be equalled");
        }
        double result = 0;
        for (int i = 0; i < x.length; i++) {
            result += x[i] * y[i];
        }
        return result;
    }

    public static double[][] transpose(double[][] a) {
        double[][] result = new double[a[0].length][a.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = a[j][i];
            }
        }
        return result;
    }

    public static double[][] mult(double[][] a, double[][] b) {
        if (a[0].length != b.length) {
            throw new IllegalArgumentException("a.colCount and b.rowCount must be equalled");
        }
        double[][] result = new double[a.length][b[0].length];
        double[][] transposeB = transpose(b);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = dot(a[i], transposeB[j]);
            }
        }
        return result;
    }

    public static double[] mult(double[][] a, double[] x) {
        if (a[0].length != x.length) {
            throw new IllegalArgumentException("a.colCount and x.length must be equalled");
        }
        double[] result = new double[a.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = dot(a[i], x);
        }
        return result;
    }

    public static double[] mult(double[] x, double[][] a) {
        if (x.length != a.length) {
            throw new IllegalArgumentException("x.length and a.rowCount must be equalled");
        }
        return mult(transpose(a), x);
    }

}
