package io.github.lianjishu.Day15_AbstractClass_Interface_InnerClass;

public class Dog extends Pet implements Swimming {
    public Dog() {
        super();
    }
    public Dog(String name, int age) {
        super(name, age);
    }
    @Override
    public void eating() {
        System.out.println("吃骨头🦴");
    }
    @Override
    public void swimming() {
        System.out.println("🐶会游泳");
    }
}