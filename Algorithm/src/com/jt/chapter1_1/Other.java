package com.jt.chapter1_1;

/**
 * Created by 姜腾 on 2020/5/3.
 */
public class Other {

    /**
     * 求最大公约数
     *
     * @param i
     * @param j
     * @return
     */
    public static int gcd(int i, int j) {
        if (j == 0) {
            return i;
        }
        if (i < j) {
            int temp = i;
            i = j;
            j = temp;
        }
        int r = i % j;
        return gcd(j, r);
    }
}
