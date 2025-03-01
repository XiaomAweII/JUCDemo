package com.mmall.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 1-2 并发编程初体验：实现一个计数功能
 *
 * @author xiaoweii
 * @create 2025-02-27 22:32
 */
@Slf4j
public class CountExample {

    // 简单理解为200个用户同时发起请求
//    private static int threadTotal = 200;
    private static int threadTotal = 1;
    // 简单理解为系统在短时间内总共接收到5000个请求
    private static int clientTotal = 5000;

    private static long count = 0;

    /**
     * 使用线程池和信号量来模拟客户端请求
     *
     * @param args
     */
    public  static void main(String[] args) {
        // 线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        // 信号量
        final Semaphore semaphore = new Semaphore(threadTotal);
        for (int index = 0; index < clientTotal; index++) {
            exec.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
            });
        }
        exec.shutdown();
        log.info("count:{}", count);
    }

    private static void add() {
        count++;
    }
}
