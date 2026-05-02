package com.zzy.Person;

import java.util.Objects;

public class Person implements Cloneable{
    private String name;
    private int age;

    public Person() {
        super();
    }
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    //重写类克隆方法 | 默认浅克隆, 基本数据类型的值被复制, 引用数值类型复制引用(原对象和克隆对象共享同一片内存)
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    //重写类比较方法 | 默认比较地址值
    @Override
    public boolean equals(Object obj) {
        // 1. 自反性：自己和自己比较
        if (this == obj) {
            return true;
        }
        // 2. null 检查
        if (obj == null) {
            return false;
        }
        // 3. 类型检查
        if (getClass() != obj.getClass()) {
            return false;
        }
        // 4. 强制转换并比较字段
        Person other = (Person) obj;
        return this.age == other.age && Objects.equals(this.name, other.name); // 使用 Objects.equals 安全比较字符串
    }
    //重写转字符串方法 | 默认输出类的地址值
    @Override
    public String toString() {
        return "Student{"+"name='" + name + "'" + ", age='" + age + "'" + "}";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
