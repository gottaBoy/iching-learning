package com.gottaboy.iching.mybatis.rpc.server;

import lombok.Data;

@Data
public class ServiceConfig<T> {
    /**
     * 类型
     */
    private Class type;
    /**
     * 实例化对象
     */
    private T instance;

    public ServiceConfig(Class type, T instance) {
        this.type = type;
        this.instance = instance;
    }
}
