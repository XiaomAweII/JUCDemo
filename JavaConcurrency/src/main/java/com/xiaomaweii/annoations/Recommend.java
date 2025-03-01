package com.xiaomaweii.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记【推荐】的类或者写法
 *
 * @author xiaoweii
 * @create 2025-03-01 20:06
 */
@Target(ElementType.TYPE)// 如果具体方法的话不是Type
@Retention(RetentionPolicy.SOURCE)
public @interface Recommend {

    String value() default "";
}
