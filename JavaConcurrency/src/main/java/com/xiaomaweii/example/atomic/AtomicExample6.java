package com.xiaomaweii.example.atomic;

import com.xiaomaweii.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 用于Atomic包的演示
 *
 * @author xiaoweii
 * @create 2025-02-27 22:32
 */
@Slf4j
@ThreadSafe
public class AtomicExample6 {

    private static AtomicBoolean isHappened = new AtomicBoolean(false);

    // 请求总数
    private static int threadTotal = 200;

    // 同时并发执行的线程数
    private static int clientTotal = 5000;

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
                    test();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        exec.shutdown();
        log.info("isHappened:{}", isHappened);
    }

    private static void test(){
        if (isHappened.compareAndSet(false,true)){
            log.info("execute");
        }
    }

}
