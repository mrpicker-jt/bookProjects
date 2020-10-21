package com.jt.sword_to_offer;

import java.util.HashMap;

/**
 * @program: Algorithm
 * @description: 数组中重复的数字
 * <p>
 * 一个长度为N的数组里所有的数字范围都在0~N-1中，找出数组中任意重复的数字
 * @author: Mrpicker
 * @create: 2020-10-21 19:20
 **/
public class Ex3_1 {
    public static void main(String[] args) {
        System.out.println(findRepeatNum(new int[]{2, 4, 5, 1, 3, 4}));
        System.out.println(findRepeatNum2(new int[]{2, 4, 5, 1, 3, 4}));
    }

    /**
     * 使用Hash 时间复杂度O(n) 空间复杂度O(n)
     *
     * @param nums
     * @return
     */
    private static Integer findRepeatNum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.get(num) != null) {
                return num;
            } else {
                map.put(num, 1);
            }
        }
        return null;
    }

    /**
     * 使用数组下标 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    private static Integer findRepeatNum2(int[] nums) {
        for (int i : nums) {
            if (nums[i] < 0 || nums[i] >= nums.length) {
                return null;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            //这里是一直循环，直到下标与下标对应的数字相等
            while (nums[i] != i) {
                int m = nums[i];
                if (nums[m] == nums[i]) {
                    return nums[i];
                }

                //swap nums[i] and nums[m]
                int temp = nums[i];
                nums[i] = nums[m];
                nums[m] = temp;

            }
        }
        return null;
    }
}
