package com.xiaomaweii.example.singleton;

import com.xiaomaweii.annoations.NotThreadSafe;

/**
 * 懒汉模式
 * 即单例实例在第一次使用时进行创建
 *
 * @author xiaoweii
 * @create 2025-03-02 22:13
 */
@NotThreadSafe
public class SingletonExample4 {

    // （必须）私有构造函数
    private SingletonExample4() {

    }

    // （必须）单例对象
    private static SingletonExample4 instance = null;

    // 静态的工厂方法 - 获取单例对象
    public static SingletonExample4 getInstance() {
        // 双重检测机制
        if (instance == null) {
            // 同步锁
            synchronized (SingletonExample4.class) {
                if (instance == null) {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }

}
