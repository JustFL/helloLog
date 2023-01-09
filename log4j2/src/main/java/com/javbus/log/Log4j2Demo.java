package com.javbus.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;


/**
 * 使用AsyncAppender实现异步日志
 * 1. 导入依赖 disruptor
 * 2. 在log4j2.xml Appenders标签中添加配置 引用console Appender
 *   <Async name="MIAA">
 *      <AppenderRef ref="async-console" />
 *   </Async>
 * 3. 在log4j2.xml Loggers标签中进行注册
 * <Loggers>
 *   <Root level="trace">
 *      <AppenderRef ref="MIAA" />
 *   </Root>
 * </Loggers>
 *
 *
 * 使用AsyncLogger实现异步日志
 * 全局异步
 * 1. 在类路径resources下添加文件 log4j2.component.properties
 * 并添加配置项 Log4jContextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector
 *
 * 混合异步
 * 注意要配置混合异步 必须注释掉全局异步的配置
 * 1. 在log4j2.xml Loggers标签中自定义异步logger
 * <AsyncLogger name="com.javbus" level="trace" includeLocation="false" additivity="false">
 *      <AppenderRef ref="console" />
 * </AsyncLogger>
 * 效果是属于com.javbus包下的类都会继承异步logger 实现异步日志输出
 * 不在com.javbus包下的其他类会继承root logger 实现同步日志输出
 *
 * 注意AsyncAppender AsyncLogger 不要同时出现
 * log4j2 全局异步日志效率最强 企业中使用较多 若有特殊需求可以使用混合异步 性能稍次
 */

public class Log4j2Demo {
    @Test
    public void quickStart() {


        // 使用log4j2的 API+实现
        Logger logger = LogManager.getLogger(Log4j2Demo.class);


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
