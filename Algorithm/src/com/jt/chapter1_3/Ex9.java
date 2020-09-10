package com.jt.chapter1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-09-10 15:15
 **/
public class Ex9 {
    public static void main(String[] args) {
        String expression = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        completeBrackets(expression.split(" "));
    }

    private static void completeBrackets(String[] expressions) {
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
                case "sqrt":
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
                                numStr = "(" + numStrs.pop() + pop + numStr + ")";
                                break;
                            case "sqrt":
                                numStr = pop + "(" + numStr + ")";
                                break;
                        }
                        numStrs.push(numStr);
                    }
                    break;
                default:
                    numStrs.push(c);
            }
        }
        StdOut.printf("result:%s", numStrs.peek());
    }
}
