package io.github.lianjishu.generics.finalexercise.model.cat;

public final class PersianCat extends Cat {
    public PersianCat() {
    }

    public PersianCat(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.printf("一只叫做%s的，%d岁的波斯猫，正在吃小饼干...%n", this.name, this.age);
    }
}
