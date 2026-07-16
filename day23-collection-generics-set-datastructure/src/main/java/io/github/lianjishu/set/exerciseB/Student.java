package io.github.lianjishu.set.exerciseB;

import java.util.Objects;

public class Student {
    public int id;
    public String name;
    public int age;
    public Gender gender;

    public Student() {
    }

    public Student(int id, String name, int age, Gender gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id
                && age == student.age
                && Objects.equals(name, student.name)
                && gender == student.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, gender);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
