package com.gottaboy.iching.mybatis.test;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class MyFormate extends Formatter {
    @Override
    public String format(LogRecord record) {
        return new Date() + "-[" + record.getSourceClassName() + "." + record.getSourceMethodName() + "]" + record.getLevel() + ":" + record.getMessage() + "\n";
    }
}
