package com.interfaces;

class Dog extends Pet implements Swimming {
    public Dog(String name, int age) {
        super(name, age);
    }
    public Dog() {
        super();
    }

    @Override
    public void swimming() {
        System.out.println("🐶会游泳");
    }
    @Override
    public void eating() {
        System.out.println("吃骨头🦴");
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
