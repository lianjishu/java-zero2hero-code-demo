package io.github.lianjishu.dynamicproxy.taste;

public interface Idol {
    // 把所有想要被代理的方法定义在接口之中

    // 唱歌🎤
    public abstract String sing(String song);

    // 跳舞💃
    public abstract void dance();
}
