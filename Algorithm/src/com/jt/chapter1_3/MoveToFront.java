package com.jt.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description: 前移编码
 * @author: Mrpicker
 * @create: 2020-09-14 18:27
 **/
public class MoveToFront {
    public static void main(String[] args) {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            int indexOf = linkedList.indexOf(s);
            if (indexOf != -1) {
                linkedList.remove(indexOf);
                linkedList.add(0, s);
            } else {
                linkedList.add(0, s);
            }
            StdOut.println(linkedList);
        }
    }


}
