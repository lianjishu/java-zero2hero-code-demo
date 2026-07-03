package io.github.lianjishu;

import java.util.ArrayList;

class ArrayListDemo02Student {
    private String name;
    private Integer age;

    public ArrayListDemo02Student() {}

    public ArrayListDemo02Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

public class ArrayLisrDemo_02 {
    public static void main(String[] args) {
        ArrayList<ArrayListDemo02Student> students = new ArrayList<>();
        ArrayListDemo02Student s1 = new ArrayListDemo02Student("Zhang San", 24);
        ArrayListDemo02Student s2 = new ArrayListDemo02Student("Li Si", 34);
        ArrayListDemo02Student s3 = new ArrayListDemo02Student("Wang Wu", 23);
        ArrayListDemo02Student s4 = new ArrayListDemo02Student("Zhao Liu", 27);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        for (var i = 0; i < students.size(); ++i) {
            ArrayListDemo02Student stu = students.get(i);
            System.out.println(stu.getName() + ", " + stu.getAge());
        }
    }
}
