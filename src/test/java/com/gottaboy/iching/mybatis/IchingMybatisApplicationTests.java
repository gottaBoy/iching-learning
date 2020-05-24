package com.gottaboy.iching.mybatis;

//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.yaml.snakeyaml.Yaml;

import java.util.List;

@SpringBootTest
class IchingMybatisApplicationTests {

    @Test
    void contextLoads() {
    }


    // https://blog.csdn.net/qqqq0199181/article/details/83857400
    // http://codingdict.com/sources/java/org.yaml.snakeyaml/62578.html
    // https://aijishu.com/a/1060000000023967
    @Test
    public void testType() throws Exception {
        Yaml yaml = new Yaml();
        List<String> ret = (List<String>)yaml.load(this.getClass().getClassLoader()
                .getResourceAsStream("test.yaml"));
        System.out.println(ret);
    }
}
