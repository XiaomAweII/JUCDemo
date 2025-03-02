package com.xiaomaweii.example.singleton;

import com.xiaomaweii.annoations.Recommend;
import com.xiaomaweii.annoations.ThreadSafe;

/**
 * 枚举模式
 *
 * @author xiaoweii
 * @create 2025-03-02 23:28
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    // 私有构造函数
    private SingletonExample7() {

    }

    // 获取对象
    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getSingleton();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample7 singleton;

        // JVM保证这个方法绝对只调用一次
        Singleton() {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getSingleton() {
            return singleton;
        }
    }
}
