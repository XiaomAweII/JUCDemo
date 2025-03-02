package com.xiaomaweii.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xiaoweii
 * @create 2025-03-02 14:18
 */
@Slf4j
public class SynchronizedExample1 {

    // 1. 修饰一个代码块
    // 被修饰的代码称作同步语句块，作用范围是大括号括起来的代码
    // 作用对象是调用这块代码的对象
    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} - {}", j, i);
            }
        }
    }

    // 2. 修饰一个方法
    // 被修饰的方法是同步方法，作用范围是整个方法，作用对象是调用这个方法的对象
    public synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} - {}", j, i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.test2(1);
        });
        executorService.execute(() -> {
            example2.test2(2);
        });
    }
}
