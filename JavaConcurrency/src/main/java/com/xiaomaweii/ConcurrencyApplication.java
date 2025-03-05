package com.xiaomaweii;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.FilterRegistration;

/**
 * @author xiaoweii
 * @create 2025-03-01 19:56
 */
@SpringBootApplication
public class ConcurrencyApplication extends WebMvcConfigurerAdapter {//继承WebMvcConfigurerAdapter时为了使用拦截器

    public static void main(String[] args) {
        SpringApplication.run(ConcurrencyApplication.class, args);
    }

    // 定义拦截那些请求
    @Bean
    public FilterRegistrationBean httpFilter() {
        // 首先声明FilterRegistrationBean实例
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        // 配置
        // 指定Filter类
        registrationBean.setFilter(new HttpFilter());
        // 当前Filter拦截那些请求url，实际中根据需要决定自己拦截那些url
        registrationBean.addUrlPatterns("/threadLocal/*");

        return registrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HttpInterceptor()).addPathPatterns("/**");
    }
}
