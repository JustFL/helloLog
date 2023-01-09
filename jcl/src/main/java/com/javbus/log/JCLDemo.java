package com.javbus.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class JCLDemo {
    @Test
    public void testQuick(){
        // 面向接口编程 接口代码不变 默认会使用jul输出日志
        // 当导入了log4j依赖并添加了log4j的配置文件后 同样的代码下使用了log4j进行日志输出
        Log log = LogFactory.getLog(JCLDemo.class);
        log.info("hello jcl");
    }
}
