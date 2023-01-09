package com.javbus.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackDemo {
    @Test
    public void quickStart() {

        Logger logger = LoggerFactory.getLogger(LogbackDemo.class);

        for (int i = 0; i < 500; i++) {
            logger.error("error msg");
            logger.warn("warn msg");
            logger.info("info msg");
            logger.debug("debug msg");
            logger.trace("trace msg");
        }

        // test async
        System.out.println("1-----------");
        System.out.println("2-----------");
        System.out.println("3-----------");
        System.out.println("4-----------");
        System.out.println("5-----------");
    }
}
