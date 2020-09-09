package com.jt.chapter1_2;

import com.jt.chapter1_1.Other;
import edu.princeton.cs.algs4.StdOut;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-08-31 14:44
 **/
public class Rational {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        //先处理好正负关系
        if (numerator < 0 && denominator < 0) {
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        } else if (!(numerator >= 0 && denominator >= 0)) {
            numerator = -1 * Math.abs(numerator);
            denominator = Math.abs(denominator);
        }
        int maxGcd = Other.gcd(Math.abs(numerator), Math.abs(denominator));
        this.numerator = numerator / maxGcd;
        this.denominator = denominator / maxGcd;
    }

    public static void main(String[] args) {
        Rational x = new Rational(6, -36);
        Rational y = new Rational(2, 8);
        StdOut.printf("x: %s\n", x.toString());
        StdOut.printf("y: %s\n", y.toString());
        StdOut.printf("x+y: %s\n", x.plus(y).toString());
        StdOut.printf("x-y: %s\n", x.minus(y).toString());
        StdOut.printf("x*y: %s\n", x.times(y).toString());
        StdOut.printf("x/y: %s\n", x.divides(y).toString());

    }

    public Rational plus(Rational b) {
        return new Rational(numerator * b.denominator + b.numerator * denominator, denominator * b.denominator);
    }

    public Rational minus(Rational b) {
        return new Rational(numerator * b.denominator - b.numerator * denominator, denominator * b.denominator);
    }

    public Rational times(Rational b) {
        return new Rational(numerator * b.numerator, denominator * b.denominator);
    }

    public Rational divides(Rational b) {
        return new Rational(numerator * b.denominator, denominator * b.numerator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Rational)) {
            return false;
        }

        Rational b = (Rational) obj;
        return numerator == b.numerator && denominator == b.denominator;
    }
}
