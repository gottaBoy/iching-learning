package com.gottaboy.iching.mybatis.rpc.center;


import cn.hutool.core.util.RandomUtil;
import com.gottaboy.iching.mybatis.rpc.register.RegistryInfo;

import java.util.List;

/**
 * @author iching
 * @since 2019/8/21
 */
public class RandomBalancer implements LoadBalancer {
    @Override
    public RegistryInfo choose(List<RegistryInfo> registryInfoList) {
        return registryInfoList.get(RandomUtil.randomInt(0,registryInfoList.size()));
    }
}
