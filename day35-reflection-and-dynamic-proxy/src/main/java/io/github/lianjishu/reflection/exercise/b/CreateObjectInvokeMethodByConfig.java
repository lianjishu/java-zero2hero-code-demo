package io.github.lianjishu.reflection.exercise.b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 练习：跟配置文件结合动态创建.
 *
 * <p>
 * 需求：反射可以跟配置文件结合的方式，动态的创建对象，并调用方法.
 * <p>
 * 思路：
 * <ol>
 * <li>定义一个全类名和方法名的配置文件（如 properties 文件）</li>
 * <li>读取配置文件，获取类的全限定名和方法名</li>
 * <li>通过反射 {@code Class.forName(...)} 加载类，并调用无参构造创建对象</li>
 * <li>通过反射 {@code getMethod(...).invoke(...)} 调用指定方法</li>
 * </ol>
 *
 * <p>
 * 这样做的好处：后期只需修改配置文件即可替换实现类，无需改动源码.
 * 这也是 Spring 等框架"控制反转（IoC）"的底层原理.
 */
public class CreateObjectInvokeMethodByConfig {
    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, IOException {

        // 1.读取配置文件的信息
        Properties prop = new Properties();
        BufferedReader br = new BufferedReader(new FileReader(
                "E:\\Projects\\Code Demo\\Java\\itheima\\java-zero2hero-code-demo\\day35-reflection-and-dynamic-proxy\\src\\main\\java\\io\\github\\lianjishu\\reflection\\exercise\\b\\info.properties"));
        prop.load(br);
        br.close();
        System.out.println(prop);

        // 获取配置: 全类名classname , 方法名method
        String classname = prop.getProperty("classname");
        String methodname = prop.getProperty("methodname");

        // 创建Class实例
        Class<?> clazz = Class.forName(classname);

        // 实现动态创建类实例
        Constructor<?> con = clazz.getDeclaredConstructor();
        Object o = con.newInstance();

        // 实现动态调用类方法
        Method method = clazz.getDeclaredMethod(methodname);
        method.invoke(o);
    }
}
