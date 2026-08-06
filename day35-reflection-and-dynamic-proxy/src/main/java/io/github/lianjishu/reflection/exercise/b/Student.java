package io.github.lianjishu.reflection.exercise.b;

/**
 * 学生类 —— 一个标准的 JavaBean, 用于反射练习.
 * 包含 5 个私有字段: name / age / gender / height / hobby,
 * 以及对应的 getter / setter、无参构造器和 toString().
 */
public class Student {

    // ==================== 字段 ====================

    private String name;
    private int age;
    private char gender;
    private double height;
    private String hobby;

    // ==================== 构造方法 ====================

    public Student() {
    }

    public Student(String name, int age, char gender, double height, String hobby) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.hobby = hobby;
    }

    // ==================== Getter / Setter ====================

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    // ==================== 业务方法 ====================

    /**
     * 学生学习: 根据 hobby 输出一段学习内容.
     * 自带 null/默认值防御, 防止反射 invoke 时 NPE.
     */
    public void study() {
        String n = (name == null) ? "(未命名)" : name;
        String h = (hobby == null) ? "(无爱好)" : hobby;
        System.out.println(n + " 正在学习 " + h + ", 年龄: " + age);
    }
}