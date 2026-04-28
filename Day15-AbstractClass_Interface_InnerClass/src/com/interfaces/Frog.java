package com.interfaces;

public class Frog extends Pet implements Swimming {
    public Frog() {
        super();
    }

    public Frog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eating() {
        System.out.println("吃虫子🐛");
    }
    @Override
    public void swimming() {
        System.out.println("🐸会游泳");
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
