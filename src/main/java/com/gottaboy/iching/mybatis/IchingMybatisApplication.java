package com.gottaboy.iching.mybatis;

import com.gottaboy.iching.mybatis.fileupload.FileProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 *
 * rpc
 * https://blog.csdn.net/qq_41373246/article/details/100009385
 * https://mp.weixin.qq.com/s/nLSjDVluMSQCUOaFkkhjsw
 * http://farsunset.com/
 * https://github.com/gottaBoy/cim-1
 * https://github.com/gottaBoy/Cimoc
 * https://blog.csdn.net/qq_31142553/article/details/86027031
 * https://so.csdn.net/so/search?q=%E8%87%AA%E5%B7%B1%E5%8A%A8%E6%89%8B%E5%86%99RPC%E6%A1%86%E6%9E%B6&t=blog&o=vip&s=&l=&f=&viparticle=
 * http://www.recorddrip.com/dokuwiki/doku.php?id=%E5%88%86%E4%BA%AB:%E6%8A%80%E6%9C%AF:gxxrpc:gxxrpc%E4%BB%8B%E7%BB%8D%E6%96%87%E6%A1%A3#%E6%9C%8D%E5%8A%A1%E7%AB%AF%E5%90%AF%E5%8A%A8
 * https://mp.weixin.qq.com/s/nLSjDVluMSQCUOaFkkhjsw
 * https://github.com/Wasabi1234/rpc-framework
 * https://mp.weixin.qq.com/s/nJNmMCR_d7Bg6TkmM0i9MQ
 * https://blog.csdn.net/qq_41373246/article/details/100009385
 * https://blog.csdn.net/Dongguabai/article/details/83625362
 *
 * mybatis
 * https://www.cnblogs.com/ityouknow/p/6834287.html
 * http://c.biancheng.net/view/4639.html
 * https://www.javaear.com/
 * https://blog.csdn.net/xudan1010/article/details/52890102
 * https://blog.csdn.net/qq920447939/article/details/80612808
 * https://blog.csdn.net/zimiao552147572/article/details/89878541?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task
 * https://blog.csdn.net/zimiao552147572/article/details/88867161
 *
 * https://blog.csdn.net/qq_43178297/article/details/88848654
 * https://blog.csdn.net/qq_43178297/article/details/88850889
 * https://www.jhipster.tech/doing-api-first-development/
 * https://github.com/swagger-api/swagger-codegen/wiki/server-stub-generator-howto
 * https://blog.csdn.net/daniel7443/article/details/51620308
 * swagger
 * https://editor.swagger.io/
 * https://converter.swagger.io/
 * https://www.geeksforgeeks.org/character-class-java/
 * https://my.oschina.net/u/2822116/blog/729592
 * https://bitbucket.org/asomov/snakeyaml/src/master/
 * https://help.finereport.com/finereport9.0/doc-view-1100.html
 * https://www.cnblogs.com/wunian7yulian/p/5498979.html
 */
@EnableConfigurationProperties({
        FileProperties.class
})
@SpringBootApplication
public class IchingMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(IchingMybatisApplication.class, args);
    }

}
