package com.zxg.maplehourse.testquartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

public class SimpleTriggerRunner {


    public static void main(String args[]) throws Exception {
        //首先要通过工厂方法schedulerFactory的一个实现获取一个Scheduler对象作为调度器

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        //获取一个下一分钟的调度时间
        Date runTime = DateBuilder.evenMinuteDate(new Date());

        JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class).withIdentity("job1_1", "jgroup1").build();

        Trigger simpleTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1_1", "tgroup1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(3).repeatForever())
                .build();
        scheduler.scheduleJob(jobDetail, simpleTrigger);


        scheduler.start();

    }


//    //创建一个jobdetail实例，指定simplejob
//    JobDetail jobDetail = new JobDetail("job1_1", "jgroup1", SimpleJob.class);
//    //通过simpletrigger 定义调度规则，马上启动，每2秒运行一次，一共运行100次
//    SimpleTrigger simpleTrigger = new SimpleTrigger("trigger1_1", "tgroup1");
//            simpleTrigger.setStartTime(new Date());
//            simpleTrigger.setRepeatInterval(2000);
//
//
//    //通过SchedulerFactory获取一个调度器实例
//    SchedulerFactory schedulerFactory = new StdSchedulerFactory();
//    //注册并进行调度
//    Scheduler scheduler = schedulerFactory.getScheduler();
//            scheduler.scheduleJob(jobDetail, simpleTrigger);
//            scheduler.start();//调动启动
}
