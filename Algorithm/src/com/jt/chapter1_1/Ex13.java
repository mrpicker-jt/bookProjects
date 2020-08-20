package com.jt.chapter1_1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-08-19 10:40
 **/
public class Ex13 {
    public static void main(String[] args) {
        int[][] testArray = new int[2][3];
        fillArray(testArray);
        printArray(testArray);
        StdOut.println("transpose");
        printArray(transposeArray(testArray));
    }

    private static void fillArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int[] childArray = array[i];
            for (int j = 0; j < childArray.length; j++) {
                array[i][j] = StdRandom.uniform(10000);
            }
        }
    }

    private static int[][] transposeArray(int[][] array) {
        int rowCount = array.length;
        int colCount = array[0].length;
        int[][] newArray = new int[colCount][rowCount];
        for (int i = 0; i < array.length; i++) {
            int[] childArray = array[i];
            for (int j = 0; j < childArray.length; j++) {
                newArray[j][i] = array[i][j];
            }
        }
        return newArray;
    }

    private static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int[] childArray = array[i];
            for (int j = 0; j < childArray.length; j++) {
                StdOut.print(array[i][j] + " ");
            }
            StdOut.println();
        }
    }
}
