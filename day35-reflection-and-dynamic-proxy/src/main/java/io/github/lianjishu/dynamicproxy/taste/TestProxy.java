package io.github.lianjishu.dynamicproxy.taste;

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
public class TestProxy {
    /**
     * 需求:
     * 外面的人想要大明星唱一首歌
     * 1. 获取代理的对象
     * 代理对象 = ProxyUtil.createProxy(大明星的对象);
     * 2. 再调用代理的唱歌方法
     * 代理对象.唱歌的方法("只因你太美");
     */
    public static void main(String[] args) {
        // 创建代理对象
        SuperIdol superIdol = new SuperIdol("鸡哥");
        Idol proxyIdol = ProxyUtil.createProxyInstance(superIdol);

        // 从代理处调用唱歌方法
        String res = proxyIdol.sing("只因你太美");
        System.out.println(res);
        // 从代理处调用跳舞方法
        proxyIdol.dance();
    }
}
