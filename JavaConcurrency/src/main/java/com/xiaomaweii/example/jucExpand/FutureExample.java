package com.xiaomaweii.example.jucExpand;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author xiaoweii
 * @create 2025-03-09 00:49
 */
@Slf4j
public class FutureExample {

    static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            log.info("do something in callable");
            Thread.sleep(5000);
            return "Done";
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 线程池提交任务，用Future接受返回值
        Future<String> future = executorService.submit(new MyCallable());
        log.info("do something in main");
        Thread.sleep(1000);

        // 获取返回值，如果没有结束则会一直阻塞
        String result = future.get();
        log.info("result: {}", result);

        executorService.shutdown();
    }
}
