package com.gottaboy.iching.mybatis.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class FilterConfiguration {


    @Bean
    public FilterRegistrationBean Filter1() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new Filter1());
        registration.addUrlPatterns("/*");
        registration.setName("Filter1");
        registration.setOrder(Integer.MAX_VALUE);
        Map<String, String> initParameters = new HashMap();
        registration.setInitParameters(initParameters);
        return registration;
    }


    @Bean
    public FilterRegistrationBean Filter2() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new Filter2());
        registration.addUrlPatterns("/*");
        registration.setName("Filter2");
        registration.setOrder(0);
        Map<String, String> initParameters = new HashMap();
        registration.setInitParameters(initParameters);
        return registration;
    }


    @Bean
    public FilterRegistrationBean Filter3() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new Filter3());
        registration.addUrlPatterns("/*");
        registration.setName("Filter3");
        registration.setOrder(Integer.MIN_VALUE);
        Map<String, String> initParameters = new HashMap();
        registration.setInitParameters(initParameters);
        return registration;
    }

}