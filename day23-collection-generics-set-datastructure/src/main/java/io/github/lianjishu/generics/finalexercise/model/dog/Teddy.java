package io.github.lianjishu.generics.finalexercise.model.dog;

public final class Teddy extends Dog {
    public Teddy() {
    }

    public Teddy(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.printf("一只叫做%s的，%d岁的泰迪，正在吃骨头，边吃边蹭...%n", this.name, this.age);
    }
}
