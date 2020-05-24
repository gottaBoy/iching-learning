package com.gottaboy.iching.mybatis.annotation;

import java.lang.annotation.*;

/**
 * https://blog.csdn.net/u013202238/article/details/85214038
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1304227703947297
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IchingTags {

    IchingTag[] value();
}
