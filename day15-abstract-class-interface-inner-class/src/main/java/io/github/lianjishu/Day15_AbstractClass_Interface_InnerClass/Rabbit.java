package io.github.lianjishu.Day15_AbstractClass_Interface_InnerClass;

public class Rabbit extends Pet {
    public Rabbit() {
        super();
    }

    public Rabbit(String name, int age) {
        super(name, age);
    }

    @Override
    public void eating() {
        System.out.println("吃胡萝卜🥕");
    }
}
