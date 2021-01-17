package com.gottaboy.iching.mybatis.rpc.center;

/**
 * @author iching
 * @since 2019/8/21
 */
public interface Invoker<T> {
    T invoker(Object[] args);
    void setResult(String result);
}
