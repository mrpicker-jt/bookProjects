package com.jt.chapter1_2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-08-28 14:52
 **/
public class Ex01 {
    public static void main(String[] args) {
        generate(20,10);
    }

    private static void generate(int N, int max) {
        StdDraw.setXscale(0, max);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(.01);

        List<Point> points = new ArrayList<>();
        double minDistance = Math.sqrt(2 * Math.pow(max, 2));
        Pair<Integer, Integer> minPairs = new Pair<>(0, 0);
        for (int i = 0; i < N; i++) {
            Point point = new Point(StdRandom.uniform() * max, StdRandom.uniform() * max);
            StdDraw.point(point.getX(), point.getY());
            points.add(point);
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                double distance = points.get(i).distanceTo(points.get(j));
                if (distance < minDistance) {
                    minDistance = distance;
                    minPairs = new Pair<>(i, j);
                }
            }
        }
        Point point1 = points.get(minPairs.getKey());
        Point point2 = points.get(minPairs.getValue());
        StdDraw.line(point1.getX(), point1.getY(), point2.getX(), point2.getY());
        StdOut.printf("minDistance:%.3f;Point1(%.3f,%.3f),Point2(%.3f,%.3f)",
                minDistance, point1.getX(),point1.getY(), point2.getX(),point2.getY());
    }
}
