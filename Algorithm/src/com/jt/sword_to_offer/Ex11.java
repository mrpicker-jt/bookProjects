package com.jt.sword_to_offer;

import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description: 旋转数组
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * <p>
 * 题解：
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-by-leetcode-s/
 *   
 * @author: Mrpicker
 * @create: 2020-12-02 15:20
 **/
public class Ex11 {
    public static void main(String[] args) {
        int[] test = {3, 4, 5, 6, 8, 1, 2, 3, 3};
        StdOut.println(String.format("minNum: %d", minNum(test)));
    }

    /**
     * 核心思想：
     * Ⅰ:数组可以明显分为两个递增数组，左数组A和右数组B。且B的最后一个元素一定小于等于A的第一个元素.
     * Ⅱ:取数组中间数 mid，与数组的最后一个元素（即B的最后一个元素） end 比较；则有三种情况
     * Ⅲ:mid<end，则mid一定在B中，那么mid右边的元素都可以排除，此时可以把end指向mid；mid >end,则mid一定在A中，那么mid左边的元素都可以排除，
     * 可以把lo 指向mid+1；如果mid==end，此时无法判断mid在A还是B中，但是可以肯定的是mid和end是重复值，那么可以使end-1，先排除掉一个重复值
     */
    private static int minNum(int[] array) {
        int lo = 0;
        int hi = array.length - 1;
        while (lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            if (array[mid] < array[hi]) {
                //如果mid小于hi，那么mid右边的元素可以舍弃
                hi = mid;
            } else if (array[mid] > array[hi]) {
                //如果mid大于hi，那么mid左边的元素包括mid都可以舍弃
                lo = mid + 1;
            } else {
                //无法判断出mid的位置，但可以先舍弃一个重复值lo
                lo--;
            }
        }
        return array[lo];
    }

}
