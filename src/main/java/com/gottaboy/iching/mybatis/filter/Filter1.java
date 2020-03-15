package com.gottaboy.iching.mybatis.filter;

import org.springframework.core.Ordered;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class Filter1 implements Filter, Ordered {


    @Override
    public void init(FilterConfig filterConfig) {

    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //favicon 不请求 否则给人执行两次的错觉
        if(!httpServletRequest.getRequestURI().contains("favicon.ico")){
            System.out.println("==== filter1 doFilter LOWEST ====" + servletRequest.getLocalAddr());
            System.out.println(httpServletRequest.getRequestURI());
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }


    @Override
    public void destroy() {
        System.out.println("==== filter1 destroy LOWEST ====");
    }


    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
