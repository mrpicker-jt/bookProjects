package com.jt.chapter1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-09-11 10:18
 **/
public class EvaluatePostfix {
    public static void main(String[] args) {

    }

    public static void evaluatePostfix(String[] expressions) {
        Stack<Double> nums = new Stack<>();

        for (String c : expressions) {
            switch (c) {
                case "+":
                case "-":
                case "*":
                case "/":
                    Double v = nums.pop();
                    switch (c) {
                        case "+":
                            v = nums.pop() + v;
                            break;
                        case "-":
                            v = nums.pop() - v;
                            break;
                        case "*":
                            v = nums.pop() * v;
                            break;
                        case "/":
                            v = nums.pop() / v;
                            break;
                    }
                    nums.push(v);
                    break;
                default:
                    nums.push(Double.valueOf(c));
            }
        }
        StdOut.printf("result:%f\n", nums.peek());
    }
}
