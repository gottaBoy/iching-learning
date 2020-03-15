package com.gottaboy.iching.mybatis.config;

import com.gottaboy.iching.mybatis.constant.EndpointConstant;
import com.gottaboy.iching.mybatis.interceptor.IamInterceptor;
import com.gottaboy.iching.mybatis.interceptor.IchingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class IamWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new IchingInterceptor()).addPathPatterns(EndpointConstant.ALL);
        registry.addInterceptor(new IamInterceptor()).addPathPatterns(EndpointConstant.ALL);
        super.addInterceptors(registry);
    }
}
