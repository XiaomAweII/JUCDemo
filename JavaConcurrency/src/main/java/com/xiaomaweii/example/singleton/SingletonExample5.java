package com.xiaomaweii.example.singleton;

import com.xiaomaweii.annoations.ThreadSafe;

/**
 * 懒汉模式
 * 即单例实例在第一次使用时进行创建
 *
 * @author xiaoweii
 * @create 2025-03-02 22:13
 */
@ThreadSafe
public class SingletonExample5 {

    // （必须）私有构造函数
    private SingletonExample5() {

    }

    // 1、memory = allocate() 分配对象的内存空间
    // 2、ctorInstance() 初始化对象
    // 3、instance = memory 设置instance指向刚分配的内存

    // 单例对象 volatile + 双重检测机制 -> 禁止指令重排
    private volatile static SingletonExample5 instance = null;

    // 静态的工厂方法 - 获取单例对象
    public static SingletonExample5 getInstance() {
        // 双重检测机制
        if (instance == null) {
            // 同步锁
            synchronized (SingletonExample5.class) {
                if (instance == null) {
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }

}
