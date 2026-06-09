package io.github.lianjishu.Day15_AbstractClass_Interface_InnerClass;

import java.util.Scanner;

public class TestInterface {
    public static void main(String[] args) {
        Pet pet = new Dog("🐶", 4);
        System.out.println(pet.getName() +  ", " + pet.getAge());
        pet.eating();
        ((Dog) pet).swimming();
        System.out.println("------------------------");
        pet = new InterfacesFrog("🐸", 1);
        System.out.println(pet.getName() +  ", " + pet.getAge());
        pet.eating();
        ((InterfacesFrog) pet).swimming();

        Scanner sc = new Scanner(System.in);
        sc.nextInt();
    }
}
