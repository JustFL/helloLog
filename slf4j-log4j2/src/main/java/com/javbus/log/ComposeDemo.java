package com.javbus.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComposeDemo {

    @Test
    public void quickStart(){
        Logger logger = LoggerFactory.getLogger(ComposeDemo.class);


        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
    }

}
