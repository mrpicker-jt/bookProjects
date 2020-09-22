package com.jt.chapter1_4;

import com.jt.util.PrintUtil;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-09-18 15:54
 **/
public class Ex12 {
    public static void main(String[] args) {
        int[] a1 = DoublingTest.generateNums(20);
        int[] a2 = DoublingTest.generateNums(30);
        Arrays.sort(a1);
        Arrays.sort(a2);
        PrintUtil.printIntArray(a1);
        PrintUtil.printIntArray(a2);
        StdOut.println();
        printsharedNums(a1,a2);
    }

    public static void printsharedNums(int[] a1, int[] a2) {
        int curA2Index = 0;
        int curA1Index = 0;
        while (curA1Index < a1.length && curA2Index < a2.length) {
            if (a1[curA1Index] == a2[curA2Index]) {
                StdOut.printf("a1[%d]:a2[%d]---%d\n", curA1Index, curA2Index, a1[curA1Index]);
                curA1Index++;
                curA2Index++;
            } else if (a1[curA1Index] > a2[curA2Index]) {
                curA2Index++;
            } else {
                curA1Index++;
            }
        }
    }
}
