package com.jt.chapter1_4;

import edu.princeton.cs.algs4.StdOut;

import java.io.IOException;
import java.util.Arrays;

/**
 * @program: Algorithm
 * @description: 计算相等的整数对数量
 * @author: Mrpicker
 * @create: 2020-09-17 17:00
 **/
public class Ex8 {
    public static void main(String[] args) throws IOException {
//        File file = new File("data" + File.separator + "1Mints.txt");
//        Path path = Paths.get(file.getAbsolutePath());
//        List<Integer> nums = Files.readAllLines(path).stream().map(String::trim).map(Integer::valueOf).collect(Collectors.toList());
//        int[] numArray = new int[nums.size()];
//        IntStream.range(0, nums.size()).forEach(i -> numArray[i] = nums.get(i));
//        StdOut.println(count(numArray));
        int[] test = {1, 1, 2, 3, 4, 5, 5, 6, 6, 6, 6};
        StdOut.println(equalSum(test));
        StdOut.println(equalSumSlow(test));
    }

    public static int equalSum(int[] array) {
        Arrays.sort(array);
        int sum = 0;
        int curEqualCount = 1;
        int lastNum = array[0];
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                if (array[i] == lastNum) {
                    curEqualCount += 1;
                } else {
                    sum += curEqualCount * (curEqualCount - 1) / 2;
                    curEqualCount = 1;
                }
                lastNum = array[i];
            }
        }
        sum += curEqualCount * (curEqualCount - 1) / 2;
        return sum;
    }

    public static int equalSumSlow(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    sum++;
                }
            }
        }
        return sum;
    }


}
