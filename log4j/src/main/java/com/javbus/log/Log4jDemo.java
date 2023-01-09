package com.javbus.log;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.junit.Test;

public class Log4jDemo {

    @Test
    public void testQuick(){
        // 加载默认的初始化配置 如果有配置文件 会加载配置文件覆盖初始配置 配置文件要放在类路径下
        BasicConfigurator.configure();

        // 将当前的类传递给consoleLogger
        Logger logger = Logger.getLogger(Log4jDemo.class);
        logger.fatal("I am fatal!!!");
        logger.error("I am error!!!");
        logger.warn("I am warn!!!");
        logger.info("I am info!!!");
        logger.debug("I am debug!!!");
        logger.trace("I am trace!!!");
    }

    // log4j记录系统日志 LogLog记录log4j的日志
    @Test
    public void testLogLog() {

        LogLog.setInternalDebugging(true);

        // 输出log4j日志 看到了自定义的appender 名字为"console" 类型是"org.apache.log4j.ConsoleAppender"
        Logger logger = Logger.getLogger(Log4jDemo.class);

        for (int i = 0; i < 500; i++) {
            logger.fatal("I am fatal!!!");
            logger.error("I am error!!!");
            logger.warn("I am warn!!!");
            logger.info("I am info!!!");
            logger.debug("I am debug!!!");
            logger.trace("I am trace!!!");
        }
    }

    @Test
    public void testCustom(){
        Logger logger = Logger.getLogger(Logger.class);
        logger.fatal("I am fatal!!!");
        logger.error("I am error!!!");
        logger.warn("I am warn!!!");
        logger.info("I am info!!!");
        logger.debug("I am debug!!!");
        logger.trace("I am trace!!!");
    }
}
