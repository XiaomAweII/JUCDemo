package com.xiaomaweii.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.xiaomaweii.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaoweii
 * @create 2025-03-04 22:48
 */
@Slf4j
@ThreadSafe
public class ImmutableExample3 {

    // 大于12之后，会使用不定参数
    private final static ImmutableList list = ImmutableList.of(1, 2, 3);

    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    private final static ImmutableMap<Integer, Integer> map = ImmutableMap.of(1, 2, 3, 4);

    private final static ImmutableMap<Integer, Integer> map2 = ImmutableMap.<Integer, Integer>builder()
            .put(1, 2).put(3, 4).put(5, 6).build();

    public static void main(String[] args) {
        // 如果调用会直接抛出异常
        list.add(4);

        // 如果调用会直接抛出异常
        set.add(4);

        // 如果调用会直接抛出异常
        map.put(1, 3);

        // 如果调用会直接抛出异常
        map2.put(1, 3);
    }

}
