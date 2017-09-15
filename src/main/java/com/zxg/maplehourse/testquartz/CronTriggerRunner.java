package com.zxg.maplehourse.testquartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class CronTriggerRunner {


    public static void main(String args[]) throws Exception {


        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

        Scheduler scheduler = schedulerFactory.getScheduler();


        JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class).withIdentity("job1_1", "jgroup1").build();
//        CronTrigger trigger = newTrigger().withIdentity("trigger1", "group1").withSchedule(cronSchedule("0/20 * * * * ?"))
//                .build();

//                newTrigger().withIdentity("trigger1", "group1").withSchedule(cronSchedule("0/20 * * * * ?"))
        CronTrigger cronTrigger = TriggerBuilder.
                newTrigger().withIdentity("trigger1", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * * * ?"))
                .build();

        scheduler.scheduleJob(jobDetail, cronTrigger);
        scheduler.start();
    }
}
