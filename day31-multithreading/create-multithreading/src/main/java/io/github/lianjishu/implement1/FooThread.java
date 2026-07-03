package io.github.lianjishu.implement1;

//继承Thread类创建一个线程
public class FooThread extends Thread{
    @Override
    public void run() {
        for(int i=0; i<10; ++i) {System.out.println(String.format("%s: %s", this.getName(), "Hello..."));}
    }
}


