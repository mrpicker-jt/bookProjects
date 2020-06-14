package com.mrpicker.concurent_programming.create_run_task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class CachedThreadPool2 {
    public static void main(String[] args) {
    ExecutorService exec
    = Executors.newCachedThreadPool();
    IntStream.range(0, 100)
    .mapToObj(InterferingTask::new)
    .forEach(exec::execute);
    exec.shutdown();
    }
}