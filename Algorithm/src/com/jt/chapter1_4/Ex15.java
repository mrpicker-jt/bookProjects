package com.jt.chapter1_4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: Algorithm
 * @description: Faster 3 sum
 * @author: Mrpicker
 * @create: 2020-09-21 15:39
 **/
public class Ex15 {
    public static void main(String[] args) {
        int[] test = {-4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        int[] doubleTest = new int[test.length * 2];
        for (int i = 0; i < doubleTest.length; i++) {
            doubleTest[i] = test[i % test.length];
        }
        Arrays.sort(test);
        Arrays.sort(doubleTest);
        StdOut.println(ThreeSumFast.count(test));
        StdOut.println(fasterSum3(test));
//        StdOut.println(TwoSumFast.count(test));
//        StdOut.println(fasterSum2(test, 0));
    }

    /**
     * @param a 已排序的数组
     * @return
     */
    public static int fasterSum2(int[] a, int sumNum) {
        StopWatch stopWatch = new StopWatch();
        int i = internalFasterSum2(a, sumNum, 0);
        StdOut.printf("fasterSum2 cost: %.5fs\n", stopWatch.elapseTime() / 1000f);
        return i;
    }

    private static int internalFasterSum2(int[] a, int sumNum, int startIndex) {
        HashMap<Integer, Integer> numCountMap = new HashMap<>();
        int count = 0;
        int zeroCount = 0;
        int curOpositeNum = a[0] - 1;
        int curOpositeCount = 0;
        for (int i = startIndex; i < a.length; i++) {
            int curI = a[i];
            if (curI < sumNum / 2f) {
                numCountMap.merge(curI, 1, (a1, b) -> a1 + b);
            } else if (curI > sumNum / 2f) {
                if (curI == curOpositeNum) {
                    curOpositeCount++;
                } else {
                    if (curOpositeCount != 0) {
                        //说明配对结束了，开始上一次的结算
                        count += curOpositeCount * numCountMap.get(sumNum - curOpositeNum);
                        curOpositeNum = a[0] - 1;
                        curOpositeCount = 0;
                    }

                    if (numCountMap.get(sumNum - curI) != null) {
                        //说明有配对的
                        curOpositeNum = curI;
                        curOpositeCount = 1;
                    }
                }
            } else {
                zeroCount++;
            }
        }
        if (curOpositeCount != 0) {
            count += curOpositeCount * numCountMap.get(sumNum - curOpositeNum);
        }
        count += zeroCount * (zeroCount - 1) / 2;
        return count;
    }


    /**
     * @param a 有序数组
     * @return
     */
    public static int fasterSum3(int[] a) {
        StopWatch stopWatch = new StopWatch();
        int count = 0;
        for (int i = 0; i < a.length - 1; i++) {
            int i1 = internalFasterSum2(a, -a[i], i + 1);
            count += i1;
        }
        StdOut.printf("fasterSum3 cost: %.5fs\n", stopWatch.elapseTime() / 1000f);
        return count;
    }
}
