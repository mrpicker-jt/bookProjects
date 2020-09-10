package com.jt.chapter1_3;

import com.jt.chapter1_3.intefaces.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-09-09 15:17
 **/
public class LinkStack<T> implements Iterable<T>, Stack<T> {

    private Node<T> first;
    private int N;

    public static void main(String[] args) {
        LinkStack<Integer> stack = new LinkStack<>();
        for (int i = 0; i < 20; i++) {
            stack.push(i);
        }
        for (Integer i : stack) {
            StdOut.printf("%4d", i);
        }
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<T> oldFirst = first;
        first = oldFirst.next;
        N--;
        return oldFirst.item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return first.item;
    }

    @Override
    public void push(T item) {
        Node<T> node = new Node<>();
        node.item = item;
        node.next = first;
        first = node;
        N++;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> cur = first;

            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public T next() {
                Node<T> prev = cur;
                cur = cur.next;
                return prev.item;
            }
        };
    }
}
