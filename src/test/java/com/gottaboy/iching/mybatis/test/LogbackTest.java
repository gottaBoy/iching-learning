package com.gottaboy.iching.mybatis.test;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackTest {
    private static final Logger logger = LoggerFactory.getLogger(LogbackTest.class);

    public static void main(String[] args){
        short a = 1;
        a += 1;
        System.out.println(a);
        System.out.println(a);
//        if(logger.isDebugEnabled()){
//            logger.debug("slf4j-logback debug message");
//        }
//        if(logger.isInfoEnabled()){
//            logger.debug("slf4j-logback info message");
//        }
//        if(logger.isTraceEnabled()){
//            logger.debug("slf4j-logback trace message");
//        }
//
//        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
//        StatusPrinter.print(lc);
    }
}
