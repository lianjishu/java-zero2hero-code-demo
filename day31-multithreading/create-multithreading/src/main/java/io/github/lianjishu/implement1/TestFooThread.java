package io.github.lianjishu.implement1;

public class TestFooThread {
    public static void main(String[] args) {
        FooThread fpt1 = new FooThread();
        FooThread fpt2 = new FooThread();

        fpt1.setName("线程1");
        fpt2.setName("线程2");

        fpt1.start();
        fpt2.start();

    }
}
