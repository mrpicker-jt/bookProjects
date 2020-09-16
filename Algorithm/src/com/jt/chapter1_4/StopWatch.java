package com.jt.chapter1_4;

/**
 * @program: Algorithm
 * @description:
 * @author: Mrpicker
 * @create: 2020-09-16 13:30
 **/
public class StopWatch {
    long createTimestamp;

    public StopWatch() {
        createTimestamp = System.currentTimeMillis();
    }

    public long elapseTime() {
        return System.currentTimeMillis() - createTimestamp;
    }
}
