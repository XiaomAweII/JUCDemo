package com.xiaomaweii;

import com.xiaomaweii.example.threadLocal.RequestHolder;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * @author xiaoweii
 * @create 2025-03-04 23:46
 */
@Slf4j
public class HttpFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 通常在使用时，需要将ServletRequest强转为HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // 这里需要在登录的时候往里塞入对应的值，因为没做登录所以就不写了
        // request.getSession().getAttribute("user");

        // 打印日志 线程id和当前请求
        log.info("do filter, {}, {}", Thread.currentThread().getId(), request.getServletPath());
        RequestHolder.add(Thread.currentThread().getId());

        // 如果filter不想要拦截这个请求，只想做单独的数据处理，这里需要调用filterChain.doFilter()方法将之前的request和servlet传进去，这样保证这个拦截器执行完同时让请求继续被处理
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
