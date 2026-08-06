package io.github.lianjishu.dynamicproxy.taste;

public class SuperIdol implements Idol{
    private String name;

    public SuperIdol(String name) {
        this.name = name;
    }

    public SuperIdol() {
    }

    @Override
    public String sing(String song) {
        System.out.println(this.name + "正在唱" + song + "...");
        return "谢谢!";
    }

    @Override 
    public void dance() {
        System.out.println(this.name + "正在跳舞" + "...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SuperIdol [name=" + name + "]";
    }

}
