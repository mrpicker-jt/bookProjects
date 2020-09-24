package com.jt.chapter1_4;

import com.jt.util.PrintUtil;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Algorithm
 * @description: 最接近的一对
 * @author: Mrpicker
 * @create: 2020-09-22 15:37
 **/
public class Ex16 {
    public static void main(String[] args) {
        double[] test = {0, 1, 3, -7, 2, 5, 8, -8, 9};
        PrintUtil.printDoubleArray(findMinGapPair(test));
    }

    private static double[] findMinGapPair(double[] a) {
        double[] min = new double[2];
        List<Pair<Double, Double>> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            list.add(new Pair<>(Math.abs(a[i]), a[i]));
        }
        list.sort((o1, o2) -> o1.getKey().equals(o2.getKey()) ? 0 : o1.getKey() > o2.getKey() ? 1 : -1);
        min[0] = list.get(0).getValue();
        min[1] = list.get(1).getValue();
        double minGap = getAbsGap(list.get(0).getKey(), list.get(1).getKey());
        for (int i = 1; i < list.size() - 1; i++) {
            double gap = getAbsGap(list.get(i).getKey(), list.get(i + 1).getKey());
            if (gap < minGap) {
                minGap = gap;
                min[0] = list.get(i).getValue();
                min[1] = list.get(i + 1).getValue();
            }
        }

        return min;
    }

    private static double getAbsGap(double i, double j) {
        return Math.abs(Math.abs(i) - Math.abs(j));
    }

}
