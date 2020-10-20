package com.jt.leetcode_practice;/**
 * Created by 姜腾 on 2020/10/20.
 */

import com.jt.chapter1_3.Node;
import com.jt.chapter1_3.SinglyLinkedList;
import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description: 使用链表代替加法
 * @author: Mrpicker
 * @create: 2020-10-20 22:56
 **/
public class AddTwoNumbers {
    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>();
        node1.item = 2;
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>(node1);
        list1.add(9);
        list1.add(9);
        list1.add(9);
        Node<Integer> node2 = new Node<>();
        node2.item = 7;
        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>(node2);
        list2.add(9);
        list2.add(8);
        list2.add(6);

        Node<Integer> integerNode = addTwoNumbers(node1, node2);
        SinglyLinkedList<Integer> newList = new SinglyLinkedList<>(integerNode);
        StdOut.println(list1);
        StdOut.println(list2);
        StdOut.println(newList);
    }

    private static Node<Integer> addTwoNumbers(Node<Integer> node1, Node<Integer> node2) {
        Node<Integer> curNode1 = node1;
        Node<Integer> curNode2 = node2;
        Node<Integer> firstNode = new Node<>();
        Node<Integer> curNode = firstNode;

        int extraNumber = 0;//这是欠的数
        while (curNode1 != null || curNode2 != null) {
            Integer i1 = curNode1 != null ? curNode1.item : 0;
            Integer i2 = curNode2 != null ? curNode2.item : 0;
            int result = i1 + i2 + extraNumber;
            //如果result大于等于10，那么减去10后再向后一位加1
            if (result >= 10) {
                curNode.item = result - 10;
                extraNumber = 1;
            } else {
                curNode.item = result;
                extraNumber = 0;
            }
            curNode1 = curNode1.next;
            curNode2 = curNode2.next;
            if (curNode1 != null || curNode2 != null) {
                curNode.next = new Node<>();
                curNode = curNode.next;
            }
        }
        if (extraNumber != 0) {
            curNode.next = new Node<>();
            curNode = curNode.next;
            curNode.item = extraNumber;
        }
        return firstNode;
    }
}
