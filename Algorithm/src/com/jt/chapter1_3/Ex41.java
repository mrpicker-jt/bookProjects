package com.jt.chapter1_3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description: copy queue
 * @author: Mrpicker
 * @create: 2020-09-15 09:52
 **/
public class Ex41 {
    public static void main(String[] args) {
        Queue<String> queue=new Queue<>();
        queue.enqueue("i");
        queue.enqueue("love");
        queue.enqueue("you");
        Queue<String> copyQueue = copyQueue(queue);
        queue.dequeue();
        StdOut.println(queue);
        StdOut.println(copyQueue);
    }

    private static  <T> Queue<T> copyQueue(Queue<T> queue) {
        Queue<T> newQueue = new Queue<>();
        for (T t : queue) {
            newQueue.enqueue(t);
        }
        return newQueue;
    }
}
