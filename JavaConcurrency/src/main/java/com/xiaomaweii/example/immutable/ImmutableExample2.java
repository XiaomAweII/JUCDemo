package com.xiaomaweii.example.immutable;

import com.google.common.collect.Maps;
import com.xiaomaweii.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * @author xiaoweii
 * @create 2025-03-04 22:48
 */
@Slf4j
@ThreadSafe
public class ImmutableExample2 {

    private static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        map.put(1, 3);// 使用不可变Collections.unmodifiableMap(map)修饰之后，会直接抛出异常
        log.info("{}", map.get(1));
    }

}
