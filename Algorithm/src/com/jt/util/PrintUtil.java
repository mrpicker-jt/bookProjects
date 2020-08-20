package com.jt.util;

import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-08-19 13:52
 **/
public class PrintUtil {
    public static void printIntArray(int[] array) {
        StdOut.println();
        for (Integer anArray : array) {
            StdOut.print(anArray);
            StdOut.print(" ");
        }
    }

    public static void printIntArray(int[][] array) {
        StdOut.println();
        for (int[] anArray : array) {
            printIntArray(anArray);
        }
    }

    public static void printDoubleArray(double[] array) {
        StdOut.println();
        for (double d:array){
            StdOut.printf("%10.2f",d);
        }
    }

    public static void printDoubleArray(double[][] array) {
        StdOut.println();
        for (double[] anArray : array) {
            printDoubleArray(anArray);
        }
    }
}
