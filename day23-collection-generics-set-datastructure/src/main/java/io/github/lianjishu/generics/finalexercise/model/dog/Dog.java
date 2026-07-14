package io.github.lianjishu.generics.finalexercise.model.dog;

import io.github.lianjishu.generics.finalexercise.model.animal.Animal;

public abstract class Dog extends Animal {
    public Dog() {
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    public abstract void eat();
}
