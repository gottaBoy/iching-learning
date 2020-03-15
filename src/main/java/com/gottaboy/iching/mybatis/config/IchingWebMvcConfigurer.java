package com.gottaboy.iching.mybatis.config;

import com.gottaboy.iching.mybatis.constant.EndpointConstant;
import com.gottaboy.iching.mybatis.interceptor.IchingInterceptor;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class IchingWebMvcConfigurer implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor ichingInterceptor() {
        return new IchingInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ichingInterceptor()).addPathPatterns(EndpointConstant.ALL);
    }
}
