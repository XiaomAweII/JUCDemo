package com.xiaomaweii.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author xiaoweii
 * @create 2025-03-08 17:40
 */
@Slf4j
public class SemaphoreExample2 {
    // 线程数
    private final static int threadCount = 20;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService exec = Executors.newCachedThreadPool();

        // 允许并发数
        final Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    // 这时和单线程操作就很像了，因为一次拿了三个许可
                    semaphore.acquire(3);// 获取多个许可
                    test(threadNum);
                    semaphore.release(3);// 释放多个许可
                } catch (Exception e) {
                    log.error("exception", e);
                }
            });
        }
        log.info("finish");
        exec.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        log.info("{}", threadNum);
        Thread.sleep(1000);
    }
}
