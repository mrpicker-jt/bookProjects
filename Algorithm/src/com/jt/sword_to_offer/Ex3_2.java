package com.jt.sword_to_offer;

/**
 * @program: Algorithm
 * @description: 不修改数组找出重复的数字
 * <p>
 * 长度为N+1的数组李所有的数字都在1-n的范围内，所以至少有一个数字是重复的，找出任意一个重复数字，但不能修改输入的数组
 * @author: Mrpicker
 * @create: 2020-10-21 20:08
 **/
public class Ex3_2 {

    public static void main(String[] args) {
        int[] test = new int[]{2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(findRepeatNum1(test));
        System.out.println(findRepeatNum2(test));

    }

    /**
     * 搞一个长度为N+1的辅助数组
     * 时间O(n) 空间O(n)
     *
     * @param a
     * @return
     */
    private static int findRepeatNum1(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 1 || a[i] >= a.length) {
                return -1;
            }
        }

        int[] ex_a = new int[a.length];
        for (int i = 0; i < ex_a.length; i++) {
            ex_a[i] = 0;
        }
        for (int i = 0; i < a.length; i++) {
            if (ex_a[a[i]] > 0) {
                return a[i];
            } else {
                ex_a[a[i]] = 1;
            }
        }
        return -1;
    }

    /**
     * 核心思想，如果数组中在 lo-mid中的数字大于mid-lo+1,
     * 那么说明lo-mid中一定有一个重复的数字
     * <p>
     * 时间O(nlg(n)) 空间O(1)
     *
     * @param a
     * @return
     */
    private static int findRepeatNum2(int[] a) {
        int lo = 1;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int count = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] >= lo && a[i] <= mid) {
                    count++;
                }
            }
            if (lo == hi) {
                if (count > 1) {
                    return lo;
                } else {
                    break;
                }
            }
            if (count > (mid - lo + 1)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }

        }

        return -1;
    }

}
