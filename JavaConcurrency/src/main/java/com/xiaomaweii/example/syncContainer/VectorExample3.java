package com.xiaomaweii.example.syncContainer;

import com.xiaomaweii.annoations.NotThreadSafe;

import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author xiaoweii
 * @create 2025-03-07 23:20
 */
public class VectorExample3 {

    // java.util.ConcurrentModificationException
    // 建议在遍历时不去做更新操作
    // 如需进行更新，做好标记，在遍历之后再做删除操作
    private static void test1(Vector<Integer> v1) { // forEach
        for (Integer i : v1) {
            if (i.equals(3)) {
                v1.remove(i);
            }
        }
    }

    // java.util.ConcurrentModificationException
    // 在多线程操作当中使用迭代器进行更新操作的时候，可以使用synchronized或者lock来做一些同步措施
    // 同时可以使用并发容器如CopyOnWriteArrayList来替代ArrayList和Vector
    private static void test2(Vector<Integer> v1) { // Iterator
        Iterator<Integer> iterator = v1.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next.equals(3)) {
                v1.remove(next);
            }
        }
    }

    // success
    // 推荐使用for循环
    private static void test3(Vector<Integer> v1) { // for
        for (int i = 0; i < v1.size(); i++) {
            if (v1.get(i).equals(3)) {
                v1.remove(i);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        test1(vector);
    }
}
