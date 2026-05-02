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

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }
}
