package com.jt.chapter1_4;

import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-09-16 10:19
 **/
public class ThreeSum {
    public static void main(String[] args) throws IOException {
        File file = new File("data" + File.separator + "8Kints.txt");
        Path path = Paths.get(file.getAbsolutePath());
        List<Integer> nums = Files.readAllLines(path).stream().map(String::trim).map(Integer::valueOf).collect(Collectors.toList());
        StdOut.println(count(nums));
    }

    public static int count(List<Integer> a) {
        StopWatch stopWatch = new StopWatch();
        int N = a.size();
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (a.get(i) + a.get(j) + a.get(k) == 0) count++;
                }
            }
        }
        StdOut.printf("ThreeSum cost: %.3fs\n", stopWatch.elapseTime() / 1000f);
        return count;
    }
}
