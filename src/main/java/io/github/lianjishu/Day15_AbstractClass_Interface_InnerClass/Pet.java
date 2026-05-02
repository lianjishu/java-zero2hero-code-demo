package io.github.lianjishu.Day15_AbstractClass_Interface_InnerClass;

public abstract class Pet {
    private String name;
    private int age;

    public Pet(){}
    public Pet(String name , int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void eating();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
