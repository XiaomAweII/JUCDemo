package com.xiaomaweii.example.count;

import com.xiaomaweii.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 用于最基础的并发测试
 *
 * @author xiaoweii
 * @create 2025-02-27 22:32
 */
@Slf4j
@NotThreadSafe
public class CountExample1 {

    // 请求总数
    private static int threadTotal = 200;

    // 同时并发执行的线程数
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
