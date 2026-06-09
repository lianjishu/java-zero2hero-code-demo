package io.github.lianjishu.Day15_AbstractClass_Interface_InnerClass;

public class Frog extends Animal {
    public Frog() {}
    public Frog(String name, int age) {
        super(name, age);
    }
    @Override
    public void eating() {
        System.out.println("吃🐛");
    }
}