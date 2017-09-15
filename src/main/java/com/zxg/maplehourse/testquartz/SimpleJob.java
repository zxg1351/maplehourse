package com.zxg.maplehourse.testquartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class SimpleJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("execute job at" + new Date() + " by trigger "
                + jobExecutionContext.getTrigger().getKey().getName() + "triggered.time is: " + new Date());
    }
}
