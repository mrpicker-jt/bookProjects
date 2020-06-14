package com.mrpicker.concurent_programming.create_run_task;

public class InterferingTask implements Runnable {
    private static Integer val = 0;
    final int id;

    public InterferingTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++)
            val++;
        System.out.println(id + " " +
                Thread.currentThread().getName() + " " + val);
    }
}