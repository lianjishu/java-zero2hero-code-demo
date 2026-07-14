package io.github.lianjishu.generics.finalexercise.model.cat;

import io.github.lianjishu.generics.finalexercise.model.animal.Animal;

public abstract class Cat extends Animal {

    public Cat() {

    }

    public Cat(String name, int age) {
        super(name, age);
    }

    public abstract void eat();
}
