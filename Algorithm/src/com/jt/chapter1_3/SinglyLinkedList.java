package com.jt.chapter1_3;

import com.jt.chapter1_3.intefaces.SimpleList;
import edu.princeton.cs.algs4.StdOut;

import java.util.stream.IntStream;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-09-11 13:47
 **/
public class SinglyLinkedList<T> implements SimpleList<T> {
    Node<T> first;
    int size;

    public SinglyLinkedList() {
        first = null;
        size = 0;
    }

    public SinglyLinkedList(Node<T> firstNode) {
        first = firstNode;
        Node<T> cur = first;
        size = 1;
        while (cur.next != null) {
            size++;
            cur = cur.next;
            if (cur.next == first) {
                //如果是回环，断开回环
                cur.next = null;
                break;
            }
        }
    }


    public static void main(String[] args) {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(38);
        linkedList.add(38);
        IntStream.range(0, 20).forEach(x -> linkedList.add(x * 2));
        linkedList.add(38);
        linkedList.add(38);
        linkedList.add(38);
        IntStream.range(0, 20).forEach(x -> linkedList.add(x * 2));
        StdOut.println(linkedList);
        linkedList.remove(Integer.valueOf(38));
        StdOut.println(linkedList);
        linkedList.removeAll(Integer.valueOf(38));
        StdOut.println(linkedList);
        linkedList.remove(0);
        StdOut.println(linkedList);
        linkedList.add(0, 999);
        StdOut.println(linkedList);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(T t) {
        Node<T> node = new Node<>();
        node.item = t;
        if (first == null) {
            first = node;
            size++;
            return;
        }
        Node<T> last = first;
        while (last.next != null) {
            last = last.next;
        }
        last.next = node;
        size++;
    }

    @Override
    public void add(int index, T t) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = new Node<>();
        node.item = t;
        if (index == 0) {
            node.next = first;
            first = node;
            size++;
            return;
        }
        Node<T> before = first;
        int curIndex = 0;
        while (curIndex < index - 1) {
            before = before.next;
            curIndex++;
        }
        node.next = before.next;
        before.next = node;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            first = first.next;
            size--;
            return;
        }
        //先找到要被移除的前一个
        Node<T> before = first;
        int curIndex = 0;
        while (curIndex < index - 1) {
            before = before.next;
            curIndex++;
        }
        Node<T> toRemove = before.next;
        before.next = toRemove.next;
        size--;
    }

    @Override
    public boolean remove(T t) {
        if (!isEmpty()) {
            Node<T> before = first;
            if (first.item.equals(t)) {
                first = first.next;
                size--;
                return true;
            }
            while (before.next != null) {
                if (before.next.item.equals(t)) {
                    before.next = before.next.next;
                    size--;
                    return true;
                } else {
                    before = before.next;
                }
            }
            return false;
        }
        return false;
    }

    public void removeAll(T t) {
        if (!isEmpty()) {
            Node<T> before = first;
            if (first.item.equals(t)) {
                first = first.next;
                size--;
//                return true;
            }
            while (before.next != null) {
                if (before.next.item.equals(t)) {
                    before.next = before.next.next;
                    size--;
//                    return true;
                } else {
                    before = before.next;
                }
            }
//            return false;
        }
//        return false;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> cur = first;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.item;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<T> cur = first;
        while (cur != null) {
            stringBuilder.append(cur.item.toString()).append(" ");
            cur = cur.next;
        }
        return stringBuilder.toString();
    }
}
