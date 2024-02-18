package com.scheduling;

import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

// https://www.baeldung.com/java-priority-job-schedule
public class PriorityJobScheduler {
    private ExecutorService priorityJobPoolExecutor;
    private ExecutorService priorityJobSceduler
            = Executors.newSingleThreadExecutor();
    private PriorityBlockingQueue<Job> priorityQueue;

    public PriorityJobScheduler(Integer poolSize, Integer queueSize){
        priorityJobPoolExecutor = Executors.newFixedThreadPool(poolSize);
        priorityQueue = new PriorityBlockingQueue<Job>(
                queueSize,
                Comparator.comparing(Job::getJobPriority)
        );
        priorityJobSceduler.execute(() -> {
            while (true){
                try {
                    priorityJobPoolExecutor.execute(priorityQueue.take());
                }catch (InterruptedException e){
                    // exception needs special handling
                    break;
                }
            }
        });
    }

    public void scheduleJob(Job job){
        priorityQueue.add(job);
    }

    public void shutdown(){
        priorityJobSceduler.shutdown();
    }
    public void shutdownNow(){
        this.shutdownNow();
    }

    public static void main(String[] args) {
        PriorityJobScheduler obj = new PriorityJobScheduler(2,10);
        obj.scheduleJob(new Job("j1", JobPriority.LOW));
        obj.scheduleJob(new Job("j2", JobPriority.MEDIUM));
        obj.scheduleJob(new Job("j3", JobPriority.MEDIUM));
        obj.scheduleJob(new Job("j4", JobPriority.HIGH));
        obj.scheduleJob(new Job("j5", JobPriority.MEDIUM));
        obj.scheduleJob(new Job("j6", JobPriority.LOW));
        obj.scheduleJob(new Job("j7", JobPriority.HIGH));

        obj.shutdown();
    }
}
