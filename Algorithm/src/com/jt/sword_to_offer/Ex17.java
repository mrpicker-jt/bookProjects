package com.jt.sword_to_offer;

import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description: 从1打印到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * @author: Mrpicker
 * @create: 2020-12-15 20:06
 **/
public class Ex17 {
    public static void main(String[] args) {
        print(3);
    }

    private static void print(int n) {
        if (n > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                stringBuilder.append('0');
            }
            while (increase(stringBuilder, n - 1)) {
                int noneZeroIndex = 0;
                for (int i = 0; i < n; i++) {
                    if (stringBuilder.toString().charAt(i) != '0') {
                        break;
                    }
                    noneZeroIndex++;
                }
                StdOut.println(stringBuilder.toString().substring(noneZeroIndex, stringBuilder.length()));
            }
        }
    }

    private static boolean increase(StringBuilder builder, int index) {
        char c = builder.toString().charAt(index);
        if (c == '9') {
            if (index == 0) {
                return false;
            }
            //说明要进位
            builder.replace(index, index + 1, String.valueOf('0'));
            return increase(builder, index - 1);
        } else {
            builder.replace(index, index + 1, String.valueOf((char) (c + 1)));
            return true;
        }
    }
}
