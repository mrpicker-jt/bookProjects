package com.jt.chapter1_3;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-09-11 16:53
 **/
public class Ex30 {
    public static void main(String[] args) {

    }

    public <T> void reverseLinkedList(Node<T> firstNode) {
        Node<T> cur = firstNode;
        while (cur.next != null) {
            if (cur.next == firstNode) {
                break;
            }
            cur = cur.next;
        }
        cur.next = firstNode;//把链表连成环链表，此时cur指向last
    }
}
