package com.jt.sword_to_offer;

import com.jt.chapter1_3.LinkStack;
import com.jt.chapter1_3.Node;
import com.jt.chapter1_3.SinglyLinkedList;
import edu.princeton.cs.algs4.StdOut;

import java.util.stream.IntStream;

/**
 * @program: Algorithm
 * @description: 从尾到头打印链表
 * @author: Mrpicker
 * @create: 2020-10-27 20:35
 **/
public class Ex6 {
    public static void main(String[] args) {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        IntStream.range(0, 10).forEach(i -> {
            linkedList.add("item" + i);
        });
        reversePrintNode(linkedList.getFirst());
        StdOut.println();
        StdOut.println(recursePrintNode(linkedList.getFirst()));
    }


    /**
     * 先进后出，典型的栈结构
     *
     * @param first
     * @param <T>
     */
    private static <T> void reversePrintNode(Node<T> first) {
        LinkStack<T> stack = new LinkStack<>();
        Node<T> cur = first;
        while (cur != null) {
            stack.push(cur.item);
            cur = cur.next;
        }
        for (T t : stack) {
            StdOut.print(String.format("%s ", t.toString()));
        }
    }


    private static String recursePrintNode(Node<String> node) {
        if (node.next == null) {
            return node.item;
        } else {
            return recursePrintNode(node.next) + " " + node.item;
        }
    }


}
