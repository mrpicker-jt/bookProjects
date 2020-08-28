package com.jt.chapter1_2;

import edu.princeton.cs.algs4.*;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-08-28 15:57
 **/
public class Ex03 {
    public static void main(String[] args) {
        int N = 10;
        int min = 10;
        int max = 100;

        StdDraw.setXscale(0, max);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(.001);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.rectangle((max + min) >> 1, (max + min) >> 1,
                (max - min) >> 1, (max - min) >> 1);
        StdDraw.setPenColor(StdDraw.BLACK);

        Interval2D[] interval2DS = new Interval2D[N];
        Point2D[] leftBottomPoints = new Point2D[N];
        Point2D[] rightTopPoints = new Point2D[N];
        for (int i = 0; i < N; i++) {
            int x1 = min + StdRandom.uniform(max - min);
            int x2 = min + StdRandom.uniform(max - min);
            int y1 = min + StdRandom.uniform(max - min);
            int y2 = min + StdRandom.uniform(max - min);
            Interval1D xLine = new Interval1D(Math.min(x1, x2), Math.max(x1, x2));
            Interval1D yLine = new Interval1D(Math.min(y1, y2), Math.max(y1, y2));
            leftBottomPoints[i] = new Point2D(xLine.min(), yLine.min());
            rightTopPoints[i] = new Point2D(xLine.max(), yLine.max());


            Interval2D interval2D = new Interval2D(xLine, yLine);
            interval2DS[i] = interval2D;
            interval2D.draw();
        }
        int intersectCount = 0;
        int containCount = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                Interval2D interval2D = interval2DS[i];
                Interval2D interval2D1 = interval2DS[j];
                if (j > i) {
                    if (interval2D.intersects(interval2D1)) {
                        intersectCount++;
                    }
                }

                if (j != i) {
                    if (interval2D.contains(leftBottomPoints[j])&&interval2D.contains(rightTopPoints[j])){
                         containCount++;
                    }
                }
            }
        }
        StdOut.printf("intersectCount:%d  containCount:%d",intersectCount,containCount);
    }
}
