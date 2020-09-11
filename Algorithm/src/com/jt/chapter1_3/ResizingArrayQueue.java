package com.jt.chapter1_3;

import com.jt.chapter1_3.intefaces.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-09-11 10:42
 **/
public class ResizingArrayQueue<T> implements Queue<T>, Iterable<T> {

    static final int INITIAL_SIZE = 10;
    private int N;
    private T[] array = (T[]) new Object[INITIAL_SIZE];

    public static void main(String[] args) {
        ResizingArrayQueue<String> queue = new ResizingArrayQueue<>();
        queue.enQueue("i");
        queue.enQueue("love");
        queue.enQueue("you");
        queue.enQueue("very");
        queue.enQueue("much");
        StdOut.println(queue);
        queue.deQueue();
        StdOut.println(queue);
        queue.enQueue("very");
        StdOut.println(queue);
    }


    @Override
    public T deQueue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T t = array[0];
        for (int i = 0; i < N; i++) {
            if (i == N - 1) {
                array[i] = null;
            } else {
                array[i] = array[i + 1];
            }
        }
        N--;
        calculateSize();
        return t;
    }

    @Override
    public void enQueue(T item) {
        calculateSize();
        array[N] = item;
        N++;
    }

    private void calculateSize() {
        if (N == array.length) {
            moveToMax(array.length * 2);
        } else if (N > 0 && array.length / N == 4) {
            moveToMax(array.length / 2);
        }
    }

    private void moveToMax(int max) {
        T[] newArray = (T[]) new Object[max];
        for (int i = 0; i < N; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (T t : this) {
            stringBuilder.append(t.toString() + " ");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int curIndex = 0;

            @Override
            public boolean hasNext() {
                return curIndex < N;
            }

            @Override
            public T next() {
                return array[curIndex++];
            }
        };
    }
}
