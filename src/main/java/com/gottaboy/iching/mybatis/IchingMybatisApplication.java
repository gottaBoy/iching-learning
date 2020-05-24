package com.gottaboy.iching.mybatis;

import com.gottaboy.iching.mybatis.fileupload.FileProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
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
