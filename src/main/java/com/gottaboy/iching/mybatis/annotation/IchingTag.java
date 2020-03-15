package com.gottaboy.iching.mybatis.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repeatable(value = IchingTags.class)
public @interface IchingTag {

    String value() default "";
}
