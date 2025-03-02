package com.xiaomaweii.example.singleton;

import com.xiaomaweii.annoations.ThreadSafe;

/**
 * 饿汉模式
 * 即单例实例在类装载时进行创建
 *
 * @author xiaoweii
 * @create 2025-03-02 22:13
 */
@ThreadSafe
public class SingletonExample2 {

    // （必须）私有构造函数
    private SingletonExample2() {

    }

    // （必须）单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    // 静态的工厂方法
    public static SingletonExample2 getInstance() {
        return instance;
    }

}
