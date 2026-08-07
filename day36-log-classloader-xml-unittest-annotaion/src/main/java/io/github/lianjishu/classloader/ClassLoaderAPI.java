package io.github.lianjishu.classloader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 类加载器相关方法
 * 
 * 方法名 说明
 * public static ClassLoader getSystemClassLoader() 获取系统类加载器
 * public InputStream getResourceAsStream(String name) 加载某一个资源文件
 */
public class ClassLoaderAPI {
    public static void main(String[] args) throws IOException {
        // public static ClassLoader getSystemClassLoader() 获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // public InputStream getResourceAsStream(String name) 加载某一个资源文件
        // ClassLoader.getResourceAsStream(String name) 中的 name 是 classpath
        // 下的相对路径，不接受Windows 绝对路径。
        InputStream is = systemClassLoader.getResourceAsStream("logback.xml");

        Properties prop = new Properties();
        prop.load(is);
        System.out.println(prop);
        is.close();
    }
}
