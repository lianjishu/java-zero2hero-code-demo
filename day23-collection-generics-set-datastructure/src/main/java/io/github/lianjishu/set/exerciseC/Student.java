package io.github.lianjishu.set.exerciseC;

import java.time.LocalDate;
import java.time.Period;

/**
 * 学生类
 * <p>
 * 学生对象属性：
 * </p>
 * <ul>
 * <li>姓名</li>
 * <li>出生日期（age 由 birthday 派生）</li>
 * </ul>
 *
 * @author lianjishu
 * @since 2026-07-16
 * @see java.util.TreeSet
 * @see java.lang.Comparable
 */
public class Student implements Comparable<Student> {

    /** 姓名 */
    private String name;

    /** 出生日期 */
    private LocalDate birthday;

    /** 年龄 */
    private int age;

    /** 无参构造方法 */
    public Student() {
    }

    /** 全参构造方法 */
    public Student(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
        // this.age = 现在-生日;
        this.age = Period.between(birthday, LocalDate.now()).getYears();
    }

    /** 获取姓名 */
    public String getName() {
        return name;
    }

    /** 设置姓名 */
    public void setName(String name) {
        this.name = name;
    }

    /** 获取出生日期 */
    public LocalDate getBirthday() {
        return birthday;
    }

    /** 设置出生日期 */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     * 派生字段：根据出生日期计算当前年龄。
     *
     * @return 距离 today 的完整年数
     */
    public int getAge() {
        if (birthday == null) {
            return 0;
        }
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    /**
     * 自然排序：先年龄升序，同年龄按姓名（忽略大小写）字母序。
     *
     * <p>
     * 等价 Comparator 写法（仅作注释参考）：
     * 
     * <pre>{@code
     * TreeSet<Student> set = new TreeSet<>(
     *         Comparator.comparingInt(Student::getAge)
     *                 .thenComparing(Student::getName, String::compareToIgnoreCase));
     * }</pre>
     *
     * <p>
     * 去重语义由 compareTo == 0 自动满足：同姓名同年龄 compareTo 返回 0，TreeSet 视为重复元素。
     * </p>
     */
    @Override
    public int compareTo(Student other) {
        // TODO: 按"年龄升序 → 同年龄按名字母序"实现
        // 提示：
        // 1. 用 Integer.compare(this.getAge(), other.getAge()) 比较年龄
        // 2. 年龄相同时,用 this.name.compareToIgnoreCase(other.name) 比较姓名
        // 3. 年龄和姓名都相同时, 返回 0(TreeSet 据此判定重复)
        int byAge = this.age - other.getAge();
        // int byAge = other.age - this.getAge();
        if (byAge != 0)
            return byAge;
        return this.name.compareToIgnoreCase(other.getName());
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + getAge() + ", birthday=" + birthday + "}";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (age != other.age)
            return false;
        return true;
    }

}