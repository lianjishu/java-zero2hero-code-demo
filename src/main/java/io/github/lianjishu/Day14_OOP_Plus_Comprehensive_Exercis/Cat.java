package io.github.lianjishu.Day14_OOP_Plus_Comprehensive_Exercis;
public class Cat extends Animal{
    public Cat() {}
    public Cat(int age, String color){
        super(age, color);
    }
    public void catchMouse() {
        System.out.println("抓老鼠......");
    }
}
