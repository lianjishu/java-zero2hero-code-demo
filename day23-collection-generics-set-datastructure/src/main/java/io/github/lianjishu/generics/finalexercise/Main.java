package io.github.lianjishu.generics.finalexercise;

import io.github.lianjishu.generics.finalexercise.model.animal.Animal;
import io.github.lianjishu.generics.finalexercise.model.cat.Cat;
import io.github.lianjishu.generics.finalexercise.model.cat.LihuaCat;
import io.github.lianjishu.generics.finalexercise.model.cat.PersianCat;
import io.github.lianjishu.generics.finalexercise.model.dog.Dog;
import io.github.lianjishu.generics.finalexercise.model.dog.Husky;
import io.github.lianjishu.generics.finalexercise.model.dog.Teddy;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    /**
     * 要求 1：该方法能养所有品种的猫，但是不能养狗
     */
    public static void keepPet1(ArrayList<? extends Cat> pets) {
        pets.forEach(Cat::eat);
    }

    /**
     * 要求 2：该方法能养所有品种的狗，但是不能养猫
     */
    public static void keepPet2(ArrayList<? extends Dog> pets) {
        pets.forEach(Dog::eat);
    }

    /**
     * 要求 3：该方法能养所有的动物，但是不能传递其他类型
     */
    public static void keepPet3(ArrayList<? extends Animal> pets) {
        pets.forEach(Animal::eat);
    }

    public static void main(String[] args) {
        // 定义一些猫猫狗狗
        LihuaCat liHua = new LihuaCat("花花", 2);
        PersianCat persian = new PersianCat("波斯", 3);
        Husky husky = new Husky("二哈", 1);
        Teddy teddy = new Teddy("小泰", 4);
        // 该方法能养所有品种的猫，但是不能养狗
        System.out.println("// 该方法能养所有品种的猫，但是不能养狗");
        keepPet1(new ArrayList<>(Arrays.asList(
                liHua, persian
        )));
        System.out.println();

        // 该方法能养所有品种的狗，但是不能养猫
        System.out.println("// 该方法能养所有品种的狗，但是不能养猫");
        keepPet2(new ArrayList<>(Arrays.asList(
                husky, teddy
        )));
        System.out.println();

        // 该方法能养所有的动物，但是不能传递其他类型
        System.out.println("// 该方法能养所有的动物，但是不能传递其他类型");
        keepPet3(new ArrayList<>(Arrays.asList(
                liHua, persian, husky, teddy
        )));
        System.out.println();
    }
}
