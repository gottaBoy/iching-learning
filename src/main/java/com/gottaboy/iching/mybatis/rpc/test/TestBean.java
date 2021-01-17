package com.gottaboy.iching.mybatis.rpc.test;

import lombok.Data;

/**
 * @author iching
 * @since 2019/8/21
 */
@Data
public class TestBean {
    private String name;
    private Integer age;

    public TestBean(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
