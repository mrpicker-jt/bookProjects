package com.jt.chapter1_3;

import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description: copy stack
 * @author: Mrpicker
 * @create: 2020-09-15 09:59
 **/
public class Ex42 {
    public static void main(String[] args) {
        LinkStack<String> linkStack=new LinkStack<>();
        linkStack.push("i");
        linkStack.push("love");
        linkStack.push("you");
        LinkStack<String> newStack=new LinkStack<>(linkStack);
        linkStack.pop();
        StdOut.println(linkStack);
        StdOut.println(newStack);
    }
}
