package com.gottaboy.iching.mybatis.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdkLogger {
    public static Logger logger = Logger.getLogger(Number.class.getName());

    static {
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.SEVERE);
        logger.addHandler(handler);
    }

    public static void main(String[] args) {
        logger.setLevel(Level.INFO);
        logger.finest("finest log ...");
        logger.finer("finer log ...");
        logger.fine("fine log ...");
        logger.config("config log ...");
        logger.info("info log ...");
        logger.warning("warning log ...");
        logger.severe("severe log ...");
    }
}
