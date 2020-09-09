package com.jt.chapter1_3;

import com.jt.chapter1_3.intefaces.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-09-09 16:39
 **/
public class LinkQueue<T> implements Iterable<T>, Queue<T> {

    private Node<T> head;
    private Node<T> tail;
    private int N;

    public static void main(String[] args) {
        LinkQueue<Integer> queue = new LinkQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.enQueue(i);
        }
        for (Integer i : queue) {
            StdOut.printf("%4d", i);
        }
    }

    @Override
    public T deQueue() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> node = head;
        head = node.next;
        if (isEmpty()) {
            tail = null;
        }
        N--;
        return node.item;
    }

    @Override
    public void enQueue(T item) {
        N++;
        Node<T> node = new Node<>();
        node.item = item;
        if (isEmpty()) {
            head = tail = node;
            return;
        }
        Node<T> oldTail = tail;
        oldTail.next = node;
        tail = node;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> cur = head;

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
