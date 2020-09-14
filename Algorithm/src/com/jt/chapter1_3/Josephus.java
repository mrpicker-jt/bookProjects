package com.jt.chapter1_3;

import com.jimmysun.algorithms.chapter1_3.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.stream.IntStream;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-09-14 16:21
 **/
public class Josephus {
    public static void main(String[] args) {
        int N = 7;
        int M = 2;
        Queue<Integer> queue = new Queue<>();
        IntStream.range(0, N).forEach(queue::enqueue);
        int curCount = 0;//计数
        while (queue.size() > 1) {
            Integer dequeue = queue.dequeue();
            curCount++;
            if (curCount == M) {
                curCount = 0;//这个人被杀了，重新计数
                StdOut.print(dequeue + " ");
            } else {
                queue.enqueue(dequeue);
            }
        }
        StdOut.println(queue.dequeue());
        StdOut.println(josephus(N,M));
    }

    private static int josephus(int N, int M) {
        if (N == 1) {
            return 0;
        }
        return (josephus(N - 1, M) + M) % N;
    }
}
