package com.xiaomaweii.example.concurrent;

import com.xiaomaweii.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;
import java.util.concurrent.*;

/**
 * @author xiaoweii
 * @create 2025-03-06 23:26
 */
@Slf4j
@ThreadSafe
public class CopyOnWriteArraySetExample {
    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    private static Set<Integer> set = new CopyOnWriteArraySet<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
            exec.execute(() -> {
                try {
                    semaphore.acquire();
                    update(count);
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        exec.shutdown();
        log.info("size:{}", set.size());
    }

    private static void update(int i) {
        set.add(i);
    }
}
