package com.comprehensive_exercise;

public class PingPongPlayer extends Person implements SpeakingEng{
    public PingPongPlayer() {
        super();
    }
    public PingPongPlayer(String name, int age) {
        super(name, age);
    }

    @Override
    public void working() {
        System.out.println("学打乒乓球🏓");
    }

    @Override
    public int getAge() {
        return super.getAge();
    }
    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    public String getName() {
        return super.getName();
    }
    @Override
    public void setName(String name) {
        super.setName(name);
    }
    @Override
    public void speaking_english() {
        System.out.println("会说英语");
    }
}
