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
public class SingletonExample6 {

    // （必须）私有构造函数
    private SingletonExample6() {

    }

    // （必须）单例对象
    private static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }

    // 静态的工厂方法
    public static SingletonExample6 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }

}
