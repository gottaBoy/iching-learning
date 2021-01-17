package com.gottaboy.iching.mybatis.rpc.test;

import com.gottaboy.iching.mybatis.rpc.center.ApplicationContext;
import com.gottaboy.iching.mybatis.rpc.client.ReferenceConfig;

import java.util.Collections;

/**
 * @author iching
 * @since 2019/8/21
 */
public class TestConsumer {

    public static void  main (String[] args) throws Exception {
        ReferenceConfig serviceConfig=new ReferenceConfig(ITestService.class);
        String registerUrl="zookeeper://127.0.0.1:2181";
        ApplicationContext ctx = new ApplicationContext(registerUrl,null, Collections.singletonList(serviceConfig),8090);
        ITestService service = ctx.getService(ITestService.class);
        String test = service.test(new TestBean("iching", 18), "你好啊");
        System.out.println(test);
        Runtime.getRuntime().exit(0);
    }
}
