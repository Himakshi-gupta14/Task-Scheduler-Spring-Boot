package com.Himakshi.gupta.Learn.scheduler;

public class task implements Runnable {
    private String name;

    public task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Executing task: " + name+" on thread "+Thread.currentThread().getName());
    }

}
