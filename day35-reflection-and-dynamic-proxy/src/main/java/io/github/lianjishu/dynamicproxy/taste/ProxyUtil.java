package io.github.lianjishu.dynamicproxy.taste;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//用来创建代理的工具类
public class ProxyUtil {
    private ProxyUtil() {
    }

    public static Idol createProxyInstance(SuperIdol superIdol) {
        /**
         * ● java.lang.reflect.Proxy 类: 提供了为对象产生代理对象的方法：
         * 
         * public static Object newProxyInstance(ClassLoader loader, Class<?>[]
         * interfaces, InvocationHandler h)
         * 
         * 参数一: 用于指定用哪个类加载器, 去加载生成的代理类
         * 参数二: 指定接口, 这些接口用于指定生成的代理长什么, 也就是有哪些方法
         * 参数三: 用来指定生成的代理对象要干什么事情
         * 
         */
        return (Idol) Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(), // 用于指定用哪个类加载器, 去加载生成的代理类
                new Class<?>[] { Idol.class }, // 指定接口, 这些接口用于指定生成的代理长什么, 也就是有哪些方法
                // 用来指定生成的代理对象要干什么事情 (代理帮明星收钱准备场地等!!!)
                new InvocationHandler() {
                    @Override
                    public Object invoke(
                            Object proxy, // 参数一: 代理的对象
                            Method method, // 参数二: 要运行的方法 sing
                            Object[] args) // 参数三: 调用sing方法时, 传递的实参
                            throws Throwable {
                        //代理本身的工作
                        if ("sing".equals(method.getName()))
                            System.out.println("准备话筒, 收钱💰");
                        else if ("dance".equals(method.getName())) {
                            System.out.println("准备场地, 收钱💰");
                        }
                        //代理请明星去做的工作
                        //代理本身并不唱歌跳舞!!! 
                        //去找Idol唱歌跳舞
                        return method.invoke(superIdol, args);
                    }
                });
    }
}
