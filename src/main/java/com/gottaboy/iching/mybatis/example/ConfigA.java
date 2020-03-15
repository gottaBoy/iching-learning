package com.gottaboy.iching.mybatis.example;

import com.gottaboy.iching.mybatis.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigA {
    @Bean
    public SpellChecker a() {
        return new SpellChecker();
    }
}
