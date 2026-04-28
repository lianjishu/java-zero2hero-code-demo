package com.interfaces;

import java.util.Scanner;

public class TestInterface {
    public static void main(String[] args) {
        Pet pet = new Dog("🐶", 4);
        System.out.println(pet.getName() +  ", " + pet.getAge());
        pet.eating();
        ((Dog) pet).swimming();
        System.out.println("------------------------");
        pet = new Frog("🐸", 1);
        System.out.println(pet.getName() +  ", " + pet.getAge());
        pet.eating();
        ((Frog) pet).swimming();

        Scanner sc = new Scanner(System.in);
        sc.nextInt();
    }
}
