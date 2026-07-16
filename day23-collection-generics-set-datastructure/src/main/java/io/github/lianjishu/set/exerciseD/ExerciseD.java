package io.github.lianjishu.set.exerciseD;

import java.time.LocalDate;
import java.util.TreeSet;

/**
 * 练习 TreeSet 对象排序练习题
 *
 * <p>
 * 需求：创建 {@link java.util.TreeSet} 集合，并添加 3 个学生对象
 * </p>
 *
 * <p>
 * 学生对象属性：
 * </p>
 * <ul>
 * <li>姓名</li>
 * <li>年龄</li>
 * </ul>
 *
 * <p>
 * 排序规则：
 * </p>
 * <ol>
 * <li>要求按照学生的年龄进行排序</li>
 * <li>同年龄按照姓名字母排列（暂不考虑中文）</li>
 * <li>同姓名，同年龄认为是同一个人（即 {@link java.util.TreeSet} 视为重复元素，不入库）</li>
 * </ol>
 *
 * @author lianjishu
 * @since 2026-07-16
 * @see java.util.TreeSet
 * @see java.lang.Comparable
 * @see java.util.Comparator
 */
public class ExerciseD {
    private static TreeSet<Student> getMock() {
        TreeSet<Student> students = new TreeSet<>();
        students.add(new Student("Sweetie Fox ", LocalDate.of(2001, 6, 25)));
        students.add(new Student("Diana Rider", LocalDate.of(2003, 8, 27)));
        students.add(new Student("comatozze", LocalDate.of(2004, 11, 27)));
        students.add(new Student("Polly Yangs", LocalDate.of(2004, 8, 11)));
        students.add(new Student("vanessa alessia", LocalDate.of(2004, 2, 20)));
        students.add(new Student("cutie kim", LocalDate.of(2003, 3, 1)));
        students.add(new Student("Dainty  wilder", LocalDate.of(2001, 9, 28)));
        students.add(new Student("Sierra Cute", LocalDate.of(2001, 1, 15)));
        students.add(new Student("Bella Spark", LocalDate.of(2000, 8, 11)));
        students.add(new Student("Jia lissa", LocalDate.of(1996, 9, 1)));
        students.add(new Student("Polly Yangs", LocalDate.of(2004, 8, 11))); // 完全重复，验证去重
        return students;
    }

    public static void main(String[] args) {
        var students = getMock();
        students.forEach(e -> System.out.println(e));
    }
}