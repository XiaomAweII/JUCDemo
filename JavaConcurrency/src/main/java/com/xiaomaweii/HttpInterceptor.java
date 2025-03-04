package com.xiaomaweii;

import com.xiaomaweii.example.threadLocal.RequestHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author xiaoweii
 * @create 2025-03-05 00:00
 */
@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {

    // 在接口请求之前做处理preHandle
    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle");
        return true;
    }

    // 如果出现异常
    @Override
    public void afterCompletion(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, Exception ex) throws Exception {
        RequestHolder.remove();
        log.info("afterCompletion");
        return;
    }

}
