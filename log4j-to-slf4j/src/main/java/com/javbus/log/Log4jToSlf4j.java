package com.javbus.log;

import org.apache.log4j.Logger;
import org.junit.Test;

public class Log4jToSlf4j {

    @Test
    public void quickStart(){

        /**
         * 桥接器的作用
         * 把使用log4j jul jcl旧框架项目重构为 使用slf4j+日志具体实现
         */

        // 重构之后 log4的依赖都已经去掉 但仍可以看到导入的包都是log4j的 输出的日志格式是slf4j+logback的
        Logger logger = Logger.getLogger(Log4jToSlf4j.class);

        logger.info("试验桥接器");

    }
}
