package com.xiaomaweii.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记【线程不安全类】的自定义注解（方便使用），
 *
 * 希望对于【线程不安全】的类加上 NotThreadSafe 的标识
 *
 * @author xiaoweii
 * @create 2025-03-01 20:10
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface NotThreadSafe {

    String value() default "";
}
