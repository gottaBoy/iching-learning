package com.gottaboy.iching.mybatis.rpc.client;

import lombok.Data;

/**
 * @author iching
 * @since 2019/8/20
 */
@Data
public class ReferenceConfig {

    private Class type;

    public ReferenceConfig(Class type) {
        this.type = type;
    }
}
