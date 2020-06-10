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
    //关键点
    protected List<String> keyPoints = new ArrayList<>();
    //优点
    protected List<String> benefits = new ArrayList<>();
    //缺点
    protected List<String> weakPoints = new ArrayList<>();
    //总结
    protected String summary;

    public BaseRule() {

    }

    public BaseRule(String info) {
        this.info = info;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void addBenefit(String benifit) {
        benefits.add(benifit);
    }

    public void addWeakPoint(String weakPoint) {
        weakPoints.add(weakPoint);
    }

    public void addKeyPoint(String keyPoint) {
        keyPoints.add(keyPoint);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("--------------").append(getClass().getSimpleName()).append("--------------\n");
        stringBuilder.append(String.format("Info: %s", info)).append("\n\n");
        for (int i = 0; i < keyPoints.size(); i++) {
            stringBuilder.append(String.format("KeyPoint%d: ", i + 1)).append(keyPoints.get(i)).append("\n");
        }
        for (int i = 0; i < benefits.size(); i++) {
            stringBuilder.append(String.format("Benefit%d: ", i + 1)).append(benefits.get(i)).append("\n");
        }
        for (int i = 0; i < weakPoints.size(); i++) {
            stringBuilder.append(String.format("WeakPoint%d: ", i + 1)).append(weakPoints.get(i)).append("\n");
        }
        if (summary != null) {
            stringBuilder.append(String.format("总结：%s\n", summary));
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
