package com.jt.chapter1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-09-10 16:22
 **/
public class InfixToPostfix {
    public static void main(String[] args) {
        String expression = "1 + 2 ) * 3 + 4 ) * 5 - 6 ) ) )";
        Ex9.completeBrackets(expression.split(" "));
        EvaluatePostfix.evaluatePostfix(infixToPostfix(expression.split(" ")).split(""));
    }

    private static String infixToPostfix(String[] expressions) {
        Stack<String> operatores = new Stack<>();
        Stack<String> numStrs = new Stack<>();

        for (String c : expressions) {
            switch (c) {
                case "(":
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    operatores.push(c);
                    break;
                case ")":
                    if (!operatores.isEmpty()) {
                        String pop = operatores.pop();
                        String numStr = numStrs.pop();
                        switch (pop) {
                            case "+":
                            case "-":
                            case "*":
                            case "/":
                                numStr = numStrs.pop() + numStr + pop;
                                break;
                        }
                        numStrs.push(numStr);
                    }
                    break;
                default:
                    numStrs.push(c);
            }
        }
        StdOut.printf("result:%s\n", numStrs.peek());
        return numStrs.peek();
    }
}
