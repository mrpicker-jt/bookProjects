package com.mrpicker.base;

/**
 * @program: effectiveJava
 * @description: 计时工具
 * @author: Mrpicker
 * @create: 2020-06-11 15:31
 **/
public class TimeClock {
    private static long curTime = -1;

    public static void start() {
        curTime = System.currentTimeMillis();
    }

    public static void clear() {
        curTime = -1;
    }

    public static long getTimeCost() {
        if (curTime == -1) {
            return 0;
        }
        long l = System.currentTimeMillis();
        long gap = l - curTime;
        curTime = l;
        return gap;
    }
}
