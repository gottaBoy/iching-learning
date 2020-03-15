package com.gottaboy.iching.mybatis.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IchingTags {

    IchingTag[] value();
}
