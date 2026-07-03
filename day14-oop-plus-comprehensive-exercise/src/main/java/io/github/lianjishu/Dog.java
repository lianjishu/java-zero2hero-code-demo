package io.github.lianjishu;
public class Dog extends Animal{
    public Dog(){}
    public Dog(int age, String color){
        super(age, color);
    }
    //看家行为
    public void lookHome() {
        System.out.println("看家......");
    }
}