package io.github.lianjishu.generics.finalexercise.model.dog;

public class Husky extends Dog {
    @Override
    public void eat() {
        System.out.printf("一只叫做%s的，%d岁的哈士奇，正在吃骨头，边吃边拆家...%n", this.name, this.age);
    }
}
