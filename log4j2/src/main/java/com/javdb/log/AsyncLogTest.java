package com.javdb.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class AsyncLogTest {
    @Test
    public void quickStart() {

        // 测试继承root logger的logger 进行同步日志输出
        Logger logger = LogManager.getLogger(AsyncLogTest.class);


        for (int i = 0; i < 1000; i++) {
            logger.fatal("fatal");
            logger.error("error");//默认error级别以上打印
            logger.warn("warning");
            logger.info("info");
            logger.debug("debug");
            logger.trace("trace");
        }

        for (int i = 0; i < 500; i++) {
            System.out.println("-----------------");
        }
    }
}
