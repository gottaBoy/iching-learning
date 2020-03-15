package com.gottaboy.iching.mybatis.example;

import com.gottaboy.iching.mybatis.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

/**
 * Spring JSR-250 注释
 */
@Configuration
@Import(ConfigA.class)
public class ConfigB {
    @Bean
    public Student b() {
        return new Student();
    }

    @Bean(initMethod = "init", destroyMethod = "cleanup" )
    public Foo foo() {
        return new Foo();
    }

    //@Qualifier("foo1")
    //@Required
    @Bean
    @Scope("prototype")
    public Foo foo1() {
        return new Foo();
    }
}
