package com.xiaomaweii.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaoweii
 * @create 2025-03-09 22:50
 */
@Slf4j
public class ThreadPoolExample4 {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        /*executorService.schedule(new Runnable() {
            @Override
            public void run() {
                log.warn("schedule run");
            }
        }, 3, TimeUnit.SECONDS);*/

        // 各个线程池放进去之后，延迟进行
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                log.warn("schedule run");
            }
        }, 1, 3, TimeUnit.SECONDS);
//        executorService.shutdown();

        // Timer也可以做延迟
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.warn("timer run");
            }
        }, new Date(), 5 * 1000);// 每次执行完，间隔5s，相当于一个定时器，定时去执行
    }
}
