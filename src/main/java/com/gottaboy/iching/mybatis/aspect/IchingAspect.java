package com.gottaboy.iching.mybatis.aspect;

import com.gottaboy.iching.mybatis.annotation.IchingTag;
import com.gottaboy.iching.mybatis.annotation.IchingTags;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-annotation-config
 */
@Aspect
@Component
public class IchingAspect {
    Logger logger = LoggerFactory.getLogger(IchingAspect.class);

    @Pointcut("@annotation(com.gottaboy.iching.mybatis.annotation.IchingTag)")
    public void ichingTagLayer() {
    }

    @Before(value = "ichingTagLayer() && @annotation(ichingTag)")
    public void ichingTag(IchingTag ichingTag) throws Throwable {
        String tagValue = ichingTag.value();
        System.out.println(tagValue);
    }

//    @Before(value = "ichingTagLayer() && @annotation(ichingTag) && args(name)") // args(*, *, page, ..)
//    public void ichingTag(IchingTag ichingTag, String name) throws Throwable {
//        String tagValue = ichingTag.value();
//        System.out.println(tagValue);
//        System.out.println("name: " + name);
//
//    }


//    @Before(value = "ichingTagLayer() && @annotation(ichingTags)")
//    public void ichingTags(IchingTags ichingTags) throws Throwable {
//        String tagValue = ichingTags.value().toString();
//        System.out.println(tagValue);;
//    }
}
