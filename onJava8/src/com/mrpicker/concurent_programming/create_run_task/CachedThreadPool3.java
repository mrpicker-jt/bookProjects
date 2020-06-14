package com.mrpicker.concurent_programming.create_run_task;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CachedThreadPool3 {
    public static Integer extractResult(Future<Integer> f) {
        try {
            return f.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService exec =
                Executors.newCachedThreadPool();
        List<CountingTask> tasks =
                IntStream.range(0, 100)
                        .mapToObj(CountingTask::new)
                        .collect(Collectors.toList());
        List<Future<Integer>> futures =
                exec.invokeAll(tasks);
        long startTime = System.currentTimeMillis();
        Integer sum = futures.stream()
                .map(CachedThreadPool3::extractResult)
                .reduce(0, Integer::sum);
        System.out.println("sum = " + sum);
        System.out.println("time: " + (System.currentTimeMillis() - startTime));
        exec.shutdown();


        ExecutorService exec1
                = Executors.newSingleThreadExecutor();
        Future<Integer> f = exec1.submit(new CountingTask(99));
        System.out.println(f.get()); // [1]
        exec1.shutdown();
    }
}