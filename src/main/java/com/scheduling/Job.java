package com.scheduling;


public class Job implements Runnable{
    private String jobName;
    private JobPriority jobPriority;

    public Job(String jobName, com.scheduling.JobPriority jobPriority){
        this.jobPriority = jobPriority;
        this.jobName = jobName;
    }

    @Override
    public void run() {
        System.out.println("Job: "+ jobName +
                "Priority: " + jobPriority);
        try {
            Thread.sleep(1000); // to simulate actual execution time
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public JobPriority getJobPriority() {
        return jobPriority;
    }
}
