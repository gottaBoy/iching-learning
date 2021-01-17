package com.gottaboy.iching.mybatis.rpc.register;

import java.util.List;

/**
 * @author iching
 * @since 2019/8/19
 */
public interface Registry {
    void register(Class clazz, RegistryInfo registryInfo) throws Exception;

    List<RegistryInfo> getRegistry(Class type) throws Exception;
}
