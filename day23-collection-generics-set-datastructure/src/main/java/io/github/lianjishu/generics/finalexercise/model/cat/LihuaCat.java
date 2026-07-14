package io.github.lianjishu.generics.finalexercise.model.cat;

public class LihuaCat extends Cat {
    public LihuaCat() {
    }

    public LihuaCat(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.printf("一只叫做%s的，%d岁的狸花猫，正在吃鱼...%n", this.name, this.age);
    }
}
