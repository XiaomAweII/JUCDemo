package com.xiaomaweii.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xiaoweii
 * @create 2025-03-09 22:50
 */
@Slf4j
public class ThreadPoolExample2 {

    public static void main(String[] args) {
        // 点进去其实就是 new ThreadPoolExecutor()，只不过是参数指定了
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(() -> {
                log.info("task:{}", index);
            });
        }

        executorService.shutdown();
    }
}
