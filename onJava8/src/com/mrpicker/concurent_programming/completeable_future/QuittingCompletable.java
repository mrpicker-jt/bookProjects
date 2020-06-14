package com.mrpicker.concurent_programming.completeable_future;

import com.mrpicker.concurent_programming.create_run_task.Nap;
import com.mrpicker.concurent_programming.create_run_task.QuittableTask;
import com.mrpicker.concurent_programming.create_run_task.QuittingTasks;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QuittingCompletable {
    public static void main(String[] args) {
    List<QuittableTask> tasks =
        IntStream.range(1, QuittingTasks.COUNT)
            .mapToObj(QuittableTask::new)
            .collect(Collectors.toList());
        List<CompletableFuture<Void>> cfutures =
        tasks.stream()
            .map(CompletableFuture::runAsync)
            .collect(Collectors.toList());
        new Nap(1);
        tasks.forEach(QuittableTask::quit);
        cfutures.forEach(CompletableFuture::join);
    }
}