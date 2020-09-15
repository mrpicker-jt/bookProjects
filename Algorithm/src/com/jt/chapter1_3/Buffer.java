package com.jt.chapter1_3;


import edu.princeton.cs.algs4.Stack;

/**
 * @program: Algorithm
 * @description: 文件编辑缓冲区
 * @author: Mrpicker
 * @create: 2020-09-15 10:47
 **/
public class Buffer {
    Stack<Character> leftStack;//光标左边的字符
    Stack<Character> rightStack;//光标右边的字符

    Buffer() {
        leftStack = new Stack<>();
        rightStack = new Stack<>();
    }

    public void insert(char c) {
        leftStack.push(c);
    }

    public char delete() {
        return leftStack.pop();
    }

    void left(int k) {
        for (int i = 0; i < k; i++) {
            if (leftStack.isEmpty()) {
                break;
            }
            rightStack.push(leftStack.pop());
        }
    }

    void right(int k) {
        for (int i = 0; i < k; i++) {
            if (rightStack.isEmpty()) {
                break;
            }
            leftStack.push(rightStack.pop());
        }
    }

    int size() {
        return leftStack.size() + rightStack.size();
    }

    @Override
    public String toString() {
        Stack<Character> tempStack = new Stack<>();
        for (Character c : leftStack) {
            tempStack.push(c);
        }
        return tempStack.toString() + " | " + rightStack.toString();
    }
}
