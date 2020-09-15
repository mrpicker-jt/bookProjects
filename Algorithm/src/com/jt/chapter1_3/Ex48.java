package com.jt.chapter1_3;

import com.jt.chapter1_3.intefaces.Deque;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

/**
 * @program: Algorithm
 * @description: 双向队列和栈
 * @author: Mrpicker
 * @create: 2020-09-15 12:11
 **/
public class Ex48 {
    public static void main(String[] args) {
        DoubleStackByDeque<String> doubleStack = new DoubleStackByDeque<>();
        doubleStack.pushLeft("la");
        doubleStack.pushLeft("lb");
        doubleStack.pushLeft("lc");
        doubleStack.pushRight("ra");
        doubleStack.pushRight("rb");
        doubleStack.pushRight("rc");
        StdOut.println(doubleStack.popLeft());
        StdOut.println(doubleStack.popLeft());
        StdOut.println(doubleStack.popLeft());
        StdOut.println(doubleStack.popRight());
        StdOut.println(doubleStack.popRight());
        StdOut.println(doubleStack.popRight());
//        StdOut.println(doubleStack.popLeft());
    }

    static class DoubleStackByDeque<T> {
        Deque<T> deque = new LinkedDeque<>();
        int leftSize;
        int rightSize;

        public void pushLeft(T t) {
            deque.pushLeft(t);
            leftSize++;
        }

        public void pushRight(T t) {
            deque.pushRight(t);
            rightSize++;
        }

        public T popLeft() {
            if (isLeftEmpty()) {
                throw new NoSuchElementException();
            }
            leftSize--;
            return deque.popLeft();
        }

        public T popRight() {
            if (isRightEmpty()) {
                throw new NoSuchElementException();
            }
            rightSize--;
            return deque.popRight();
        }

        public int getLeftSize() {
            return leftSize;
        }

        public int getRightSize() {
            return rightSize;
        }

        public boolean isLeftEmpty() {
            return leftSize == 0;
        }

        public boolean isRightEmpty() {
            return rightSize == 0;
        }
    }
}
