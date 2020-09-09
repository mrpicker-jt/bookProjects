package com.jt.chapter1_3;

import com.jt.chapter1_3.intefaces.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-09-09 10:40
 **/
public class ResizingArrayStack<T> implements Iterable<T>, Stack<T> {
    static final int INITIAL_SIZE = 16;

    private T[] items;
    private int N;

    public ResizingArrayStack() {
        items = (T[]) new Object[INITIAL_SIZE];
        N = 0;
    }

    public static void main(String[] args) {
        ResizingArrayStack<Integer> stack = new ResizingArrayStack<>();
        for (int i = 0; i < 20; i++) {
            stack.push(i);
        }
        for (Integer integer : stack) {
            StdOut.printf("%4d", integer);
        }
        for (int i = 0; i < 16; i++) {
            stack.pop();
        }
        StdOut.println();
        for (Integer integer : stack) {
            StdOut.printf("%4d", integer);
        }
    }

    public void push(T item) {
        checkCapacity();
        items[N] = item;
        N++;
    }

    public T pop() {
        if (!isEmpty()) {
            T result = items[--N];
            items[N] = null;
            checkCapacity();
            return result;
        } else {
            throw new RuntimeException("stack is empty");
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void checkCapacity() {
        if (N >= items.length) {
            resize(items.length * 2);
        } else if (N > 0 && N == items.length / 4) {
            resize(items.length / 2);
        }
    }

    private void resize(int max) {
        T[] newArray = (T[]) new Object[max];
        for (int i = 0; i < N; i++) {
            newArray[i] = items[i];
        }
        items = newArray;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int curIndex = N - 1;

            @Override
            public boolean hasNext() {
                return curIndex >= 0;
            }

            @Override
            public T next() {
                return items[curIndex--];
            }
        };
    }
}
