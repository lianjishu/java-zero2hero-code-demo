package io.github.lianjishu.reflection.exercise.a;

/**
 * 老师类 —— 一个标准的 JavaBean, 用于反射练习.
 * 包含 2 个私有字段: name / salary,
 * 以及对应的 getter / setter、无参构造器和 toString().
 */
public class Teacher {

    // ==================== 字段 ====================

    private String name;
    private double salary;

    // ==================== 构造方法 ====================

    public Teacher() {
    }

    public Teacher(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // ==================== Getter / Setter ====================

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // ==================== toString ====================

    @Override
    public String toString() {
        return "Teacher [name=" + name + ", salary=" + salary + "]";
    }
}