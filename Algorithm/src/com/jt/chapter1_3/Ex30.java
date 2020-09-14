package com.jt.chapter1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-09-11 16:53
 **/
public class Ex30 {
    public static void main(String[] args) {
        Node<String> firstNode = new Node<>();
        firstNode.item = "i";
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>(firstNode);
        linkedList.add("love");
        linkedList.add("you");
        StdOut.println(linkedList);

        Node<String> newNode = reverseLinkedList(firstNode);
        SinglyLinkedList<String> newLinkedList = new SinglyLinkedList<>(newNode);
        StdOut.println(newLinkedList);
    }

    public static <T> Node<T> reverseLinkedList(Node<T> firstNode) {
        Node<T> cur = firstNode;
        Stack<Node<T>> stack = new Stack<>();
        stack.push(cur);
        while (cur.next != null) {
            if (cur.next == firstNode) {
                cur.next = null;
                break;
            }
            cur = cur.next;
            stack.push(cur);
        }
        Node<T> newFirst = stack.peek();
        reverseStack(stack);
        return newFirst;
    }

    private static <T> void reverseStack(Stack<Node<T>> stack) {
        if (!stack.isEmpty()) {
            if (stack.size() == 1) {
                Node<T> pop = stack.pop();
                pop.next = null;//因为是最后一个了
            } else {
                Node<T> pop = stack.pop();
                pop.next = stack.peek();
                reverseStack(stack);
            }
        }
    }
}
