package com.jt.chapter1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-09-10 14:34
 **/
public class Ex4 {
    public static void main(String[] args) {
        String testStr1 = "({()}){}[]";
        String testStr2 = "(()){}[[]";
        StdOut.println(isParentheses(testStr1));
        StdOut.println(isParentheses(testStr2));
    }

    private static boolean isParentheses(String str) {
        String[] splits = str.split("");
        Stack<String> stack = new Stack<>();
        for (String s : splits) {
            switch (s) {
                case "(":
                case "{":
                case "[":
                    stack.push(s);
                    break;
                case ")":
                    if (!stack.pop().equals("(")) {
                        return false;
                    }
                    break;
                case "}":
                    if (!stack.pop().equals("{")) {
                        return false;
                    }
                    break;
                case "]":
                    if (!stack.pop().equals("[")) {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }
}
