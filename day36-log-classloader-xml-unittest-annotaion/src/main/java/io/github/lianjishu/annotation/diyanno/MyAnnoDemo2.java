package io.github.lianjishu.annotation.diyanno;

@MyAnno1(name = "wuhan", age = 137)
public class MyAnnoDemo2 {

    @MyAnno1(name = "wuhan", age = 137)
    String aaa;
    String bbb;

    @MyAnno1(name = "wuhan", age = 137)
    public void method1() {
        System.out.println("method1方法");
    }

    public void method2() {
        System.out.println("method2方法");
    }
}