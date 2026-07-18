package io.github.lianjishu.set.exerciseF;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 练习 TreeSet对象排序练习题
 *
 * <p>
 * 需求：创建5个学生对象
 * </p>
 *
 * <p>
 * 属性：(姓名, 年龄, 语文成绩, 数学成绩, 英语成绩),
 * </p>
 *
 * <p>
 * 排序规则：
 * </p>
 * <ol>
 * <li>按照总分从高到低输出到控制台</li>
 * <li>如果总分一样，按照语文成绩排</li>
 * <li>如果语文一样，按照数学成绩排</li>
 * <li>如果数学成绩一样，按照英语成绩排</li>
 * <li>如果英语成绩一样，按照年龄排</li>
 * <li>如果年龄一样，按照姓名的字母顺序排</li>
 * <li>如果都一样，认为是同一个学生，不存。</li>
 * </ol>
 *
 * @author lianjishu
 * @see java.util.TreeSet
 * @see java.lang.Comparable
 * @since 2026-07-17
 */
public class ExerciseF {
    private static Student[] getMockData() {
        return new Student[]{
                new Student("Sweetie Fox", 25, 88, 92, 78),
                new Student("Diana Rider", 22, 95, 81, 90),
                new Student("Comatozze", 21, 72, 85, 91),
                new Student("Polly Yangs", 21, 90, 87, 83),
                new Student("Vanessa Alessia", 22, 88, 76, 95),
                new Student("Cutie Kim", 23, 82, 89, 80),
                new Student("Dainty Wilder", 24, 75, 93, 86),
                new Student("Sierra Cute", 25, 91, 78, 84),
                new Student("Bella Spark", 25, 88, 92, 78),
                new Student("Jia Lissa", 29, 96, 94, 99),
                new Student("Polly Yangs", 21, 90, 87, 83)
        };
    }

    private static void testWithNaturalSorting() {
        // 获取TreeSet对象
        TreeSet<Student> students = new TreeSet<>();
        // 添加数据
        for (var e : getMockData())
            students.add(e);
        students.toString();
    }


    private static void testWithComparator() {
        //组装比较器链
        final Comparator<Student> RULE =
                Common.BY_TOTAL
                        .thenComparing(Common.BY_CHINESE)
                        .thenComparing(Common.BY_MATH)
                        .thenComparing(Common.BY_ENGLISH)
                        .thenComparing(Common.BY_AGE)
                        .thenComparing(Common.BY_NAME);
        // 获取TreeSet对象
        TreeSet<Student> students = new TreeSet<>(RULE);
        // 添加数据
        for (var e : getMockData())
            students.add(e);
        System.out.println(students);
    }

    public static void main(String[] args) {

        System.out.println("元素添加顺序:");
        System.out.println(studentArrayToString(getMockData()));
        System.out.println("=======================================");
        System.out.println("testWithNaturalSorting...");
//        testWithNaturalSorting();
        System.out.println("=======================================");
        System.out.println("testWithComparator...");
        testWithComparator();
        System.out.println("=======================================");

    }

    private static String studentArrayToString(Student[] primitivArr) {
        if (primitivArr.length == 0)
            return null;

        final String SPACE = "    ";
        StringBuilder sb = new StringBuilder();

        sb.append("{\n");

        for (int i = 0; i < primitivArr.length - 1; ++i)
            sb.append(String.format("%s%s,%n", SPACE, primitivArr[i].toString()));

        sb.append(String.format("%s%s%n", SPACE, primitivArr[primitivArr.length - 1]));

        sb.append("}\n");

        return sb.toString();
    }

}