package io.github.lianjishu.Day15_AbstractClass_Interface_InnerClass;

public class Dog extends Animal {
    public Dog() {
        super();
    }
    public Dog(String name, int age) {
        super(name, age);
    }
    @Override
    public void eating() {
        System.out.println("吃🦴");
    }
}