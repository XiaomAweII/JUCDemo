package com.xiaomaweii.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记【线程安全类】的自定义注解（方便使用），
 *
 * 希望对于【线程安全】的类加上 ThreadSafe 的标识
 *
 * @author xiaoweii
 * @create 2025-03-01 20:06
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ThreadSafe {

    String value() default "";
}
