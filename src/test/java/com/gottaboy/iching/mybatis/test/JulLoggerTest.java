package com.gottaboy.iching.mybatis.test;

import org.junit.Test;

import java.io.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * jdk-logging、log4j、logback日志介绍及原理
 * commons-logging与jdk-logging、log4j1、log4j2、logback的集成原理
 * slf4j与jdk-logging、log4j1、log4j2、logback的集成原理
 * slf4j、jcl、jul、log4j1、log4j2、logback大总结
 * https://my.oschina.net/pingpangkuangmo/blog/406618
 * https://my.oschina.net/pingpangkuangmo/blog/410224
 * https://www.jianshu.com/p/bbbdcb30bba8
 * http://www.iocoder.cn/Spring-Boot/Logging/
 * https://www.jianshu.com/p/727f6364ed5a
 * https://blog.csdn.net/qingkangxu/article/details/7514770
 * https://blog.csdn.net/Laiguanfu/article/details/86416501
 * https://blog.csdn.net/zhuyucheng123/article/details/51803852?utm_medium=distribute.pc_relevant.none-task-blog-baidujs-6
 */
public class JulLoggerTest {
    Logger logger = Logger.getLogger("com");

    LogManager logManager = LogManager.getLogManager();

    @Test
    public void base() {
        logger.info("info");    //信息日志
        logger.warning("warning"); //警告日志
        logger.log(Level.SEVERE,"server"); //严重日志
        logger.fine("fine");
    }
    /**
     * 日志之间存在父子关系，最顶层的日志类型为LogManager$RootLogger,命名为""
     */
    @Test
    public void test() throws IOException {
        Logger logger = Logger.getLogger("com.gottaboy.log");
        Logger logger1 = Logger.getLogger("com.gottaboy");
        Logger logger2 = Logger.getLogger("com");
        System.out.println(logger);
        System.out.println(logger1.equals(logger.getParent()));
        System.out.println(logger2.equals(logger1.getParent()));
        System.out.println(logger2.getParent());
    }

    @Test
    public void test2() throws IOException {
        InputStream in = JulLoggerTest.class.getResourceAsStream("/logging.properties");//注意配置
        logManager.readConfiguration(in);
        Logger logger = Logger.getLogger("TestLog");
        logger.setLevel(Level.ALL);
        logger.setUseParentHandlers(true);
        logger.info("INFO");
        Logger otherLog = Logger.getLogger("otherLog");
        otherLog.info("Other INFO");
    }

    @Test
    public void test3() throws IOException {
        Logger logger = Logger.getLogger("TestLog");
        logger.setLevel(Level.ALL);//设置logger的日志级别为全部，默认输出所有级别日志信息
        logger.setUseParentHandlers(false); //禁用日志原本处理类
//        FileHandler fileHandler = new FileHandler("./tmp/testJUL.log");
//        fileHandler.setLevel(Level.ALL); //记录级别
//        fileHandler.setFormatter(new MyFormate()); //设置自定义样式
//        logger.addHandler(fileHandler); //添加Handler
//        MyHandler myHandler = new MyHandler();  //创建自定义日志处理类实体
//        logger.addHandler(myHandler); //添加Handler
        logger.info("info");    //信息日志
        logger.warning("warning"); //警告日志
        logger.log(Level.SEVERE,"server"); //严重日志
        logger.fine("fine");
    }

    @Test
    public void test4() throws IOException {
//        Reader reader = new InputStreamReader(System.in);
//        reader.read();
        Writer writer = new OutputStreamWriter(System.err);
        writer.write("hello world");
//        writer.write(reader.toString());
        writer.flush();
        writer.close();
    }
}
