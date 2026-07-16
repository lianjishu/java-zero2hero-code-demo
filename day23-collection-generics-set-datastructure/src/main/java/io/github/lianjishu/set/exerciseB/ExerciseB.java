package io.github.lianjishu.set.exerciseB;

import java.util.HashSet;
import java.util.List;

/**
 * 案例：利用HashSet集合去除重复元素
 * <p>
 * 需求：创建一个存储学生对象的集合，存储多个学生对象。
 * 使用程序实现在控制台遍历该集合。
 * <p>
 * 要求：学生对象的成员变量值相同，我们就认为是同一个对象。
 */
public class ExerciseB {
    private static HashSet<Student> students = new HashSet<>(List.of(
            new Student(1, "孙悟空", 520, Gender.MALE),
            new Student(2, "猪八戒", 480, Gender.MALE),
            new Student(3, "沙悟净", 460, Gender.MALE),
            new Student(4, "唐三藏", 30, Gender.MALE),
            new Student(5, "白龙马", 300, Gender.MALE),
            new Student(6, "白骨精", 800, Gender.FEMALE),
            new Student(7, "蜘蛛精", 600, Gender.FEMALE),
            new Student(8, "玉兔精", 200, Gender.FEMALE),
            new Student(9, "嫦娥", 999, Gender.FEMALE),
            new Student(10, "铁扇公主", 600, Gender.FEMALE),
            new Student(11, "红孩儿", 100, Gender.MALE),
            new Student(12, "牛魔王", 900, Gender.MALE),
            new Student(13, "金角大王", 700, Gender.MALE),
            new Student(14, "银角大王", 680, Gender.MALE),
            new Student(15, "女儿国国王", 28, Gender.FEMALE)
    ));

    public static void main(String[] args) {
        students.forEach(student -> System.out.println(student.toString()));
    }
}
