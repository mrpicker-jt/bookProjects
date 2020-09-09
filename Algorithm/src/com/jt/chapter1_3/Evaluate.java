package com.jt.chapter1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description: Dijkstra双栈求值
 * @author: Mrpicker
 * @create: 2020-09-08 14:33
 **/
public class Evaluate {

    public static void main(String[] args) {
        String expression = "( ( 5 + 5 ) * 5 )";
        evaluate(expression.split(" "));
    }

    public static void evaluate(String[] expressions) {
        Stack<String> operatores = new Stack<>();
        Stack<Double> nums = new Stack<>();

        for (String c : expressions) {
            switch (c) {
                case "(":
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "sqrt":
                    operatores.push(c);
                    break;
                case ")":
                    if (!operatores.isEmpty()) {
                        String pop = operatores.pop();
                        double v = nums.pop();
                        switch (pop) {
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
                            case "sqrt":
                                v = Math.sqrt(v);
                                break;
                        }
                        nums.push(v);
                    }
                    break;
                default:
                    nums.push(Double.valueOf(c));
            }
        }
        StdOut.printf("result:%8f", nums.peek());
    }
}
