package com.xiaomaweii.example.count;

import com.xiaomaweii.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用synchronized保证计数一致
 *
 * @author xiaoweii
 * @create 2025-03-02 14:53
 */
@Slf4j
@ThreadSafe
public class CountExample3 {

    // 请求总数
    private static int threadTotal = 200;

    // 同时并发执行的线程数
    private static int clientTotal = 5000;

    private static int count = 0;

    /**
     * 使用线程池和信号量来模拟客户端请求
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        // 线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        // 信号量
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int index = 0; index < clientTotal; index++) {
            exec.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        exec.shutdown();
        log.info("count:{}", count);
    }

    private synchronized static void add() {
        count++;
    }
}
