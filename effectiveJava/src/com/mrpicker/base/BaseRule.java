package com.mrpicker.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: effectiveJava
 * @description: all rules extend this
 * @author: Mrpicker
 * @create: 2020-06-08 13:17
 **/
public class BaseRule {
    protected String info;
    //优点
    protected List<String> benefits = new ArrayList<>();
    //缺点
    protected List<String> weakPoints = new ArrayList<>();

    public BaseRule(String info) {
        this.info = info;
    }

    public void addBenefit(String benifit) {
        benefits.add(benifit);
    }

    public void addWeakPoint(String weakPoint) {
        weakPoints.add(weakPoint);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("--------------").append(getClass().getSimpleName()).append("--------------\n");
        stringBuilder.append(String.format("Info: %s", info)).append("\n\n");
        for (int i = 0; i < benefits.size(); i++) {
            stringBuilder.append(String.format("Benefit%d: ", i + 1)).append(benefits.get(i)).append("\n");
        }
        for (int i = 0; i < weakPoints.size(); i++) {
            stringBuilder.append(String.format("WeakPoint%d: ", i + 1)).append(weakPoints.get(i)).append("\n");
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
