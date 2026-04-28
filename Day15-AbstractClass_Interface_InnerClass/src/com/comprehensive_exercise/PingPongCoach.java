package com.comprehensive_exercise;

public class PingPongCoach extends Person implements SpeakingEng {
    public PingPongCoach() {
        super();
    }
    public PingPongCoach(String name, int age) {
        super(name, age);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }
    @Override
    public String getName() {
        return super.getName();
    }
    @Override
    public void setAge(int age) {
        super.setAge(age);
    }
    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public void working() {
        System.out.println("教打乒乓球🏓");
    }
    @Override
    public void speaking_english() {
        System.out.println("会说英语");
    }
}
