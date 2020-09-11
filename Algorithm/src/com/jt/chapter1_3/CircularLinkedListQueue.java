package com.jt.chapter1_3;

import com.jt.chapter1_3.intefaces.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Ex29
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-09-11 15:47
 **/
public class CircularLinkedListQueue<T> implements Queue<T>, Iterable<T> {
    Node<T> last;
    int size;


    public static void main(String[] args) {
        CircularLinkedListQueue<String> queue = new CircularLinkedListQueue<>();
        queue.enQueue("test");
        queue.deQueue();
        StdOut.println(queue);
        queue.enQueue("hello");
        StdOut.println(queue);
        queue.enQueue("world");
        StdOut.println(queue);
        queue.enQueue("HaHa");
        StdOut.println(queue);
        queue.deQueue();
        StdOut.println(queue);
    }

    @Override
    public T deQueue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (size == 1) {
            //避免回环
            Node<T> node = last;
            last = null;
            size--;
            return node.item;
        }
        Node<T> node = last.next;
        last.next = last.next.next;
        size--;
        return node.item;
    }

    @Override
    public void enQueue(T item) {
        Node<T> node = new Node<>();
        node.item = item;
        if (isEmpty()) {
            last = node;
            node.next = last;
            size++;
            return;
        }
        node.next = last.next;
        last.next = node;
        last = node;
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

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int curIndex = 0;
            Node<T> cur = last != null ? last.next : null;//其实就是first，因为是回环

            @Override
            public boolean hasNext() {
                //防止回环
                return curIndex < size;
            }

            @Override
            public T next() {
                T item = cur.item;
                cur = cur.next;
                curIndex++;
                return item;
            }
        };
    }
}
