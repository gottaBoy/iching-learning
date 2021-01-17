package com.gottaboy.iching.mybatis.rpc.test;

import com.gottaboy.iching.mybatis.rpc.center.ApplicationContext;
import com.gottaboy.iching.mybatis.rpc.server.ServiceConfig;

import java.util.Collections;

/**
 * @author iching
 * @since 2019/8/21
 */
public class TestProducer {
    public static void  main (String[] args) throws Exception {
        TestService testService = new TestService();
        ServiceConfig serviceConfig=new ServiceConfig<ITestService>(ITestService.class,testService);
        String registerUrl="zookeeper://127.0.0.1:2181";
        ApplicationContext ctx=new ApplicationContext(registerUrl,Collections.singletonList(serviceConfig),null,8090);
    }
}
