package com.gottaboy.iching.mybatis.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class StringTest {

    @Test
    public void testString() {
        String s0 = "ab";
        final String s1 = "b";
        String s2 = "a" + s1;
        System.out.println((s0 == s2)); //result = true
    }
}
