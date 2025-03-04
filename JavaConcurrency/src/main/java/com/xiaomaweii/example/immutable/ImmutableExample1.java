package com.xiaomaweii.example.immutable;

import com.google.common.collect.Maps;
import com.xiaomaweii.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author xiaoweii
 * @create 2025-03-04 22:48
 */
@Slf4j
@NotThreadSafe
public class ImmutableExample1 {

    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }

    public static void main(String[] args) {
//        a = 2;//编译时直接报错
//        b = "3";//编译时直接报错
//        map = Maps.newHashMap();//编译时直接报错
        map.put(1, 3);// 但是允许修改map当中的值
        log.info("{}", map.get(1));
    }

    private void test(final int a) {
//        a = 1;//编译时直接报错
    }
}
