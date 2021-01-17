package com.gottaboy.iching.mybatis.rpc.center;


import com.gottaboy.iching.mybatis.rpc.register.RegistryInfo;

import java.util.List;

/**
 * @author iching
 * @since 2019/8/21
 */
public interface LoadBalancer {
    RegistryInfo choose(List<RegistryInfo> registryInfoList);
}
