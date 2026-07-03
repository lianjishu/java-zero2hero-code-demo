package io.github.lianjishu;
public class Student {
    private String sid;
    private String name;
    private int age;
    private String address;

    public Student() {}
    public Student(String sid, String name, int age, String address) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getSid() {
        return sid;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showSelf() {
        System.out.println("ID: " + this.getSid());
        System.out.println("姓名: " + this.getName());
        System.out.println("年龄: " + this.getAge());
        System.out.println("家庭地址: " + this.getAddress());
    }
}
