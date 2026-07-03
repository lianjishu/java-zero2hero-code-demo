package io.github.lianjishu;
// 当一个接口中的抽象方法比较多的时候, 而我们只需要使用其中一部分, 使用
// 适配器可以实现这个目的

/*
 * 书写步骤:
 * 编写中间类XXXAdapter 实现对应接口
 * XXXAdapter类中空实现对应接口的各个方法
 * 让真正的实现类继承这个XXXAdapter类, 并且重写需要的方法
 * 最后XXXAdapter类需要加上abstract修饰, 避免创建XXXAdapter类的对象(无意义)
 */

public abstract class AdapterExample implements InterfaceExample {

    @Override
    public void method_A() {}

    @Override
    public void method_B() {}

    @Override
    public void method_C() {}

    @Override
    public void method_D() {}

    @Override
    public void method_E() {}

    @Override
    public void method_F() {}

    @Override
    public void method_G() {}
}
