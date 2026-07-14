package io.github.lianjishu.generics.finalexercise.model.dog;

public class Teddy extends Dog {
    @Override
    public void eat() {
        System.out.printf("一只叫做%s的，%d岁的泰迪，正在吃骨头，边吃边蹭...%n", this.name, this.age);
    }
}
