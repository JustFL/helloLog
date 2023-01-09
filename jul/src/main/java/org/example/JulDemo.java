package org.example;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.*;

public class JulDemo {

    @Test
    public void testQuick(){
        //1. 获取日志记录器对象
        Logger logger = Logger.getLogger("org.example.JulDemo");
        //2. 日志记录输出
        logger.info("hello jul");

        // 通用方法进行日志输出
        logger.log(Level.INFO, "info msg");

        // 通过占位符方式输出变量值
        String name = "Stark";
        int age = 40;
        logger.log(Level.INFO, "用户信息: {0}, {1}", new Object[]{name, age});
    }

    // 日志级别
    @Test
    public void testLevel(){

        Logger logger = Logger.getLogger("org.example.JulDemo");

        logger.log(Level.SEVERE, "severe msg");
        logger.log(Level.WARNING, "warning msg");
        logger.log(Level.INFO, "info msg");
        logger.log(Level.CONFIG, "config msg");
        logger.log(Level.FINE, "fine msg");
        // 只输出severe warning info 说明默认级别是info 比info高的级别能输出 低的不能输出
    }

    //自定义日志级别
    @Test
    public void testCustomLevel() throws IOException {

        Logger logger = Logger.getLogger("org.example.JulDemo");

        // 关闭默认日志级别
        logger.setUseParentHandlers(false);

        // 创建处理器
        ConsoleHandler consoleHandler = new ConsoleHandler();

        // 创建简单格式对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();

        // 将新建的格式化对象绑定到处理器上 并将处理器对象绑定到日志记录器上
        consoleHandler.setFormatter(simpleFormatter);
        logger.addHandler(consoleHandler);

        // 设置处理器对象的日志级别
        consoleHandler.setLevel(Level.ALL);

        // 设置日志记录器对象的日志级别
        logger.setLevel(Level.ALL);

        // 新增文件处理器对象
        FileHandler fileHandler = new FileHandler("jul.log");

        // 文件处理器对象和简单格式化对象绑定
        fileHandler.setFormatter(simpleFormatter);

        // 日志记录器对象和文件处理器对象绑定
        logger.addHandler(fileHandler);

        // specify the FileHandler's level
        fileHandler.setLevel(Level.SEVERE);


        logger.log(Level.SEVERE, "severe msg");
        logger.log(Level.WARNING, "warning msg");
        logger.log(Level.INFO, "info msg");
        logger.log(Level.CONFIG, "config msg");
        logger.log(Level.FINE, "fine msg");
        logger.log(Level.FINER, "finer msg");
        logger.log(Level.FINEST, "finest msg");
    }


    // Logger对象的父子关系
    @Test
    public void testLoggerParent(){

        // 日志对象会根据传入的名字(包名一样的层级结构)形成父子关系
        Logger father = Logger.getLogger("org");
        Logger son = Logger.getLogger("org.example");

        // LogManager类中的内部类RootLogger是所有Logger对象的顶级父类 其中定义了基本的Handler Formatter Level
        System.out.println(father.getParent());
        System.out.println(father);
        System.out.println(son.getParent());
        System.out.println(son);

        // 若自定义Logger不做任何自定义操作 会继承父类的配置
        // 这里自定义父类Logger 观察子类Logger的输出情况
        father.setUseParentHandlers(false);

        // 创建处理器
        ConsoleHandler consoleHandler = new ConsoleHandler();

        // 创建简单格式对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();

        // 将新建的格式化对象绑定到处理器上 并将处理器对象绑定到日志对象上
        consoleHandler.setFormatter(simpleFormatter);
        father.addHandler(consoleHandler);

        // 设置日志对象的日志级别和处理器对象的日志级别
        consoleHandler.setLevel(Level.WARNING);
        father.setLevel(Level.WARNING);

        son.log(Level.SEVERE, "severe msg");
        son.log(Level.WARNING, "warning msg");
        son.log(Level.INFO, "info msg");
        son.log(Level.CONFIG, "config msg");
        son.log(Level.FINE, "fine msg");
        son.log(Level.FINER, "finer msg");
        son.log(Level.FINEST, "finest msg");

    }

    // 加载自定义配置文件
    @Test
    public void testLoggerProperties() throws IOException {

        // 通过类加载器读取配置文件
        InputStream props = JulDemo.class.getClassLoader().getResourceAsStream("logging.properties");

        // 创建LogManager对象
        LogManager logManager = LogManager.getLogManager();

        // 通过LogManager加载配置文件
        logManager.readConfiguration(props);

        // 创建日志记录器对象
        Logger example = Logger.getLogger("org.example.JulDemo");

        example.severe("example severe");
        example.warning("example warning");
        example.info("example info");
        example.config("example config");
        example.fine("example fine");
        example.finer("example finer");
        example.finest("example finest");


        Logger fuck = Logger.getLogger("fuck");

        fuck.severe("fuck severe");
        fuck.warning("fuck warning");
        fuck.info("fuck info");
        fuck.config("fuck config");
        fuck.fine("fuck fine");
        fuck.finer("fuck finer");
        fuck.finest("fuck finest");

    }

}
