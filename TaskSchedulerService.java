package com.Himakshi.gupta.Learn.scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@Service
public class TaskSchedulerService {

  private BlockingQueue<task> taskQueue = new LinkedBlockingQueue<>();
    private Random random = new Random();
    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    public void createTask(String taskName) throws InterruptedException {
        task task = new task(taskName);
       taskQueue.add(task);
        long randomDelay = 1000 + random.nextInt(4000);
        scheduleTask(task, randomDelay,TimeUnit.MILLISECONDS);
        System.out.println("Task created: " + taskName + " with initial delay of " + randomDelay);
    }

    public void createTasks(String[] taskNames) throws InterruptedException {
        for (String taskName : taskNames) {
            createTask(taskName);
        }
    }

    private void scheduleTask(task task, long randomDelay,TimeUnit unit) throws InterruptedException {
        task=taskQueue.take();
        taskScheduler.schedule(
                task,
                new java.util.Date(System.currentTimeMillis() + unit.toMillis(randomDelay))
        );
    }
}