package com.gottaboy.iching.mybatis.aspect;

import com.gottaboy.iching.mybatis.annotation.CacheRedis;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
public class CacheAspect {

    Logger logger = LoggerFactory.getLogger(CacheAspect.class);

    @Pointcut(value = "@annotation(com.gottaboy.iching.mybatis.annotation.CacheRedis)")
    public void pointCut(){}

    @Before(value = "pointCut() && @annotation(cacheRedis)")
    public void before(CacheRedis cacheRedis) {
        logger.info("the result of this method will be cached.");
    }

    @AfterReturning(value = "pointCut() && @annotation(cacheRedis)",returning = "result")
    public void after(CacheRedis cacheRedis, Object result) {
        String key = cacheRedis.key();
        int expireTime = cacheRedis.expireTime();
        //do something...
        logger.info("-----redis-----[key = " + key + "]"+"[expireTime = " + expireTime + "]");
        logger.info("the result of this method is" + result + ",and has been cached.");
    }

    @Around("pointCut() && @annotation(cacheRedis)")
    public Object setCache(ProceedingJoinPoint pjp, CacheRedis cacheRedis) {
        Object result = 1;

        Method method = getMethod(pjp);//自定义注解类
        //CacheRedis cacheRedis = method.getAnnotation(CacheRedis.class);//获取key值
        String key = cacheRedis.key();
        int expireTime = cacheRedis.expireTime();
        //获取方法的返回类型,让缓存可以返回正确的类型
        Class returnType =((MethodSignature)pjp.getSignature()).getReturnType();

        logger.info("[key = " + key + "]"+"[expireTime = " + expireTime + "]");

        //接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("URI : " + request.getRequestURI());
        logger.info("URL : " + request.getRequestURL());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + pjp.getSignature().getDeclaringTypeName() + "_" + pjp.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(pjp.getArgs()));
        System.out.println("ARGS对象：" + pjp.getArgs()[0]);

        return result;
    }

    private Method getMethod(ProceedingJoinPoint joinPoint) {
        //获取参数的类型
        Method method = null;
        try {
            Signature signature = joinPoint.getSignature();
            MethodSignature msig = null;
            if (!(signature instanceof MethodSignature)) {
                throw new IllegalArgumentException("该注解只能用于方法");
            }
            msig = (MethodSignature) signature;
            method = joinPoint.getTarget().getClass().getMethod(msig.getName(), msig.getParameterTypes());
        } catch (NoSuchMethodException e) {
            logger.error("annotation no sucheMehtod", e);
        } catch (SecurityException e) {
            logger.error("annotation SecurityException", e);
        }
        return method;
    }
}