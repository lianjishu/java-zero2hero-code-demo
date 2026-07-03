package io.github.lianjishu;
public class Cat extends Animal{
    public Cat() {}
    public Cat(int age, String color){
        super(age, color);
    }
    public void catchMouse() {
        System.out.println("抓老鼠......");
    }
}
