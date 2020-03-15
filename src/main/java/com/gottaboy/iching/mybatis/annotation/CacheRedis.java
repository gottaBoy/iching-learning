package com.gottaboy.iching.mybatis.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CacheRedis {
    String key();

    int expireTime() default 600;
}