package com.gottaboy.iching.mybatis.rpc;

import lombok.Data;

@Data
public class InvokeMessage {
    private String className;
    private String methodName;
    private Class<?>[] paramTypes;
    private Object[] paramValues;
}
