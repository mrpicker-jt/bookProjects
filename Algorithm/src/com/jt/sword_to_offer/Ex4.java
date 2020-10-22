package com.jt.sword_to_offer;

/**
 * @program: Algorithm
 * @description: 二维数组中的查找
 * 一个二维数组中，每一行都是左到右递增，每一列都是上到下递增，
 * 给出一个数组和一个整数，判断此数是否在数组中
 * @author: Mrpicker
 * @create: 2020-10-22 19:56
 **/
public class Ex4 {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(isExists(a, 2));
    }

    private static boolean isExists(int[][] a, int num) {
        int i = 0;
        int j = a[0].length - 1;
        int compareCount=0;
        while (i <= a.length - 1 && j >= 0) {
            compareCount++;
            int temp = a[i][j];
            if (temp == num) {
                System.out.println("isExists.compareCount:"+compareCount);
                return true;
            } else if (temp > num) {
                j--;
            } else {
                i++;
            }
        }
        System.out.println("isExists.compareCount:"+compareCount);
        return false;
    }
}
