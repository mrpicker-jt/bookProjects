package com.jt.sword_to_offer;

import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description: 二进制中1的个数
 * <p>
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。
 * 因此，如果输入 9，则该函数输出 2。
 * @author: Mrpicker
 * @create: 2020-12-10 19:21
 **/
public class Ex15 {
    public static void main(String[] args) {
        int n = 15;
        StdOut.println(solution1(n));
        StdOut.println(solution2(n));
        StdOut.println(diffNum(n,15));
    }


    private static int solution1(int n) {
        int flag = 1;
        int count = 0;
        while (n != 0) {
            count += n & flag;//计算N的最右一位是不是1
            n >>= 1;//计算完之后右移
        }
        return count;
    }

    /**
     * 这个利用了一个特性：
     * n= n & (n-1)会将n最右边第一个1及这个1右边的所有数字都变为0
     * 这个特性也能用来判断是不是2的幂（n & (n-1) == 0 ?）
     *
     * @param n
     * @return
     */
    private static int solution2(int n) {
        if (n == 0) {
            return 0;
        }
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    /**
     * 判断m变成n需要改几位，即m与n不同的位数
     * <p>
     * 可以先异或m和n，然后看异或后1的位数
     *
     * @param m
     * @param n
     * @return
     */
    private static int diffNum(int m, int n) {
        return solution2(m ^ n);
    }


}
