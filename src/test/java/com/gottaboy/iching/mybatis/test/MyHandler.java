package com.gottaboy.iching.mybatis.test;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MyHandler extends Handler {

    private LogRecord record;

    @Override
    public void publish(LogRecord record) {
        this.record = record;
    }

    @Override
    public void flush() {
        System.out.println("logger:"+this.record.getLoggerName()+"flush");
    }

    @Override
    public void close() throws SecurityException {
        System.out.println("logger:"+this.record.getLoggerName()+"close");
    }
}
