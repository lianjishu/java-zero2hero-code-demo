package com.comprehensive_exercise;

public class BasketballPlayer extends Person {
    public BasketballPlayer() {
        super();
    }
    public BasketballPlayer(String name, int age) {
        super(name, age);
    }

    @Override
    public void working() {
        System.out.println("学打篮球🏀");
    }
    @Override
    public int getAge() {
        return super.getAge();
    }
    @Override
    public void setAge(int age) {
        super.setAge(age);
    }
    @Override
    public String getName() {
        return super.getName();
    }
    @Override
    public void setName(String name) {
        super.setName(name);
    }
}
