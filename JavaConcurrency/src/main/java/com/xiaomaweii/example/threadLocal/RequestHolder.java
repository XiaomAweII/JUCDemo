package com.xiaomaweii.example.threadLocal;

/**
 * @author xiaoweii
 * @create 2025-03-04 23:33
 */
public class RequestHolder {

    // 由于没有用户，这里存一个Long值表示当前线程的id
    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    // 在请求进入后端服务器，却没有实际处理的时候，调用相关方法将信息写入进去
    public static void add(Long id) {
        requestHolder.set(id);
    }

    public static Long getId() {
        return requestHolder.get();
    }

    // 如果不做移出的话，会造成内存泄露
    // 在接口真正处理完成之后调用，这个时候联想interceptor
    public static void remove() {
        requestHolder.remove();
    }
}
