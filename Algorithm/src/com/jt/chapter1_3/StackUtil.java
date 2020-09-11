package com.jt.chapter1_3;


import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-09-11 10:24
 **/
public class StackUtil {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("you");
        stack.push("love");
        stack.push("i");
        Stack<String> copyStack = copy(stack);
        StdOut.println(copyStack);
        copyStack.pop();
        StdOut.println(stack);
        StdOut.println(copyStack);
    }

    /**
     * Ex12
     *
     * @param stack
     * @param <T>
     * @return
     */
    public static <T> Stack<T> copy(Stack<T> stack) {
        if (stack.isEmpty()) {
            return new Stack<>();
        }
        Stack<T> copyStack = new Stack<>();
        T[] array = (T[]) new Object[stack.size()];
        int index = 0;
        for (T t : stack) {
            array[index] = t;
            index++;
        }
        for (int i = array.length - 1; i >= 0; i--) {
            copyStack.push(array[i]);
        }
        return copyStack;
    }
}
