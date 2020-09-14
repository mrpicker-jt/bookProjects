package com.jt.chapter1_3;

import com.jt.chapter1_3.intefaces.Deque;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @program: Algorithm
 * @description: 双向队列，双向链表实现
 * @author: Mrpicker
 * @create: 2020-09-14 15:48
 **/
public class LinkedDeque<T> implements Deque<T>, Iterable<T> {
    private DNode<T> left;
    private DNode<T> right;
    private int size;

    public static void main(String[] args) {
        LinkedDeque<String> deque = new LinkedDeque<>();
        deque.pushLeft("i");
        deque.pushRight("love");
        deque.pushLeft("you");
        deque.pushRight("me");
        StdOut.println(deque);
        deque.popLeft();
        deque.popRight();
        deque.popRight();
        StdOut.println(deque);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            DNode<T> cur = left;
            int loopCount = 0;

            @Override
            public boolean hasNext() {
                if (cur == left) {
                    loopCount++;
                }
                return cur != null && loopCount <= 1;
            }

            @Override
            public T next() {
                DNode<T> node = this.cur;
                cur = cur.next;
                return node.item;
            }
        };
    }

    @Override
    public T popLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        DNode<T> result = this.left;
        if (size == 1) {
            left = right = null;
        } else {
            DNode<T> next = left.next;
            next.prev = null;
            left = next;
        }
        size--;
        return result.item;
    }

    @Override
    public T popRight() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        DNode<T> result = this.right;
        if (size == 1) {
            left = right = null;
        } else {
            DNode<T> prev = right.prev;
            prev.next = null;
            right = prev;
        }
        size--;
        return result.item;
    }

    @Override
    public void pushLeft(T item) {
        DNode<T> newNode = new DNode<>();
        newNode.item = item;
        if (isEmpty()) {
            left = right = newNode;
            size++;
            return;
        }
        left.prev = newNode;
        newNode.next = left;
        left = newNode;
        size++;
    }

    @Override
    public void pushRight(T item) {
        DNode<T> newNode = new DNode<>();
        newNode.item = item;
        if (isEmpty()) {
            left = right = newNode;
            size++;
            return;
        }
        right.next = newNode;
        newNode.prev = right;
        right = newNode;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (T t : this) {
            stringBuilder.append(t.toString() + " ");
        }
        return stringBuilder.toString();
    }
}
