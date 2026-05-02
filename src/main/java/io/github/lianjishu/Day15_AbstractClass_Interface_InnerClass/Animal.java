package io.github.lianjishu.Day15_AbstractClass_Interface_InnerClass;

public abstract class Animal {
    private String name;
    private int age;

    public Animal(){}
    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void drinking() {
        System.out.println("喝水");
    }
    public abstract void eating();
}