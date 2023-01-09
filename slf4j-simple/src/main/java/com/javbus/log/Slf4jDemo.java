package com.javbus.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jDemo {

    @Test
    public void quickStart() {

        // slf4j框架 + 自带的日志具体实现 slf4j-simple
        // slf4j-simple 也必须单独导入依赖
        Logger logger = LoggerFactory.getLogger(Slf4jDemo.class);

        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");

        // 变量的拼接
        int id = 7;
        String name = "Cristiano Ronaldo";
        logger.info("Student's name is {}, number is {}.",name,id);

        // 模拟生产环境中 将日志打印到控制台(或者文件中)
        try {
            Class.forName("abc");
        } catch (ClassNotFoundException e) {
            logger.info("发现异常:", e);
        }
    }


}
