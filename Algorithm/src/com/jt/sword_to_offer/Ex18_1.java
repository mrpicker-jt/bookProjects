package com.jt.sword_to_offer;

import com.jt.chapter1_3.Node;
import com.jt.chapter1_3.SinglyLinkedList;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.List;

/**
 * @program: Algorithm
 * @description: 1.删除链表节点
 * @author: Mrpicker
 * @create: 2020-12-17 19:09
 **/
public class Ex18_1 {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        List<Integer> arr = Arrays.asList(1, 1, 2, 3, 3, 4, 4, 5, 6, 6, 7, 8, 9);
        arr.forEach(linkedList::add);
        Node<Integer> first = linkedList.getFirst();
        StdOut.println(new SinglyLinkedList<>(remove_recurse(first, 9)));

    }

    /**
     * 第1题的循环实现
     *
     * @param first
     * @param item
     * @return
     */
    private static Node<Integer> remove(Node<Integer> first, Integer item) {
        if (first.item.equals(item)) {
            return first.next;
        }
        Node<Integer> cur = first;
        while (cur.next != null && !cur.next.item.equals(item)) {
            cur = cur.next;
        }
        if (cur.next != null) {
            cur.next = cur.next.next;
        }
        return first;
    }

    /**
     * 第1题的递归实现
     *
     * @param head
     * @param item
     * @return
     */
    private static Node<Integer> remove_recurse(Node<Integer> head, Integer item) {
        if (head == null) {
            return head;
        }
        if (head.item.equals(item)) {
            return head.next;
        }
        head.next = remove_recurse(head.next, item);
        return head;
    }


}
