package com.jt.chapter1_4;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-09-16 15:22
 **/
public class TwoSumFast {
    public static void main(String[] args) throws IOException {
        File file = new File("data" + File.separator + "1Mints.txt");
        Path path = Paths.get(file.getAbsolutePath());
        List<Integer> nums = Files.readAllLines(path).stream().map(String::trim).map(Integer::valueOf).collect(Collectors.toList());
        int[] numArray = new int[nums.size()];
        IntStream.range(0, nums.size()).forEach(i -> numArray[i] = nums.get(i));
        StdOut.println(count(numArray));
    }

    public static int count(int[] a) {
        Arrays.sort(a);
        StopWatch stopWatch = new StopWatch();
        int N = a.length;
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (BinarySearch.indexOf(a, -a[i]) > i) {
                count++;
            }
        }
        StdOut.printf("TwoSum cost: %.3fs\n", stopWatch.elapseTime() / 1000f);
        return count;
    }
}
