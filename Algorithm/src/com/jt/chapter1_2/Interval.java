package com.jt.chapter1_2;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-08-28 15:29
 **/
public class Interval {
    private double left;
    private double right;

    public Interval(double left, double right) {
        if (left > right) {
            throw new RuntimeException("Interval left can't be more than right");
        }
        this.left = left;
        this.right = right;
    }

    public double getLeft() {
        return left;
    }

    public double getRight() {
        return right;
    }

    public boolean isInterSect(Interval interval) {
        return (right >= interval.left && right <= interval.right) || (left >= interval.left && left <= interval.right);
    }

    @Override
    public String toString() {
        return "Interval{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
