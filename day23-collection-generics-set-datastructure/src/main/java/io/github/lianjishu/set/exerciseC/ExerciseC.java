package io.github.lianjishu.set.exerciseC;

import java.time.LocalDate;
import java.util.TreeSet;

/**
 * TreeSet 对象排序练习。
 *
 * <p>
 * 需求：创建 TreeSet 集合，并添加 3 个学生对象
 * </p>
 *
 * <p>
 * 学生对象属性：
 * </p>
 * <ul>
 * <li>姓名</li>
 * <li>出生日期（age 由 birthday 派生）</li>
 * </ul>
 *
 * <p>
 * 排序规则：
 * </p>
 * <ol>
 * <li>按照学生的年龄进行排序</li>
 * <li>同年龄按照姓名字母排列（暂不考虑中文，使用 compareToIgnoreCase）</li>
 * <li>同姓名，同年龄认为是同一个人（compareTo == 0 时不入库）</li>
 * </ol>
 *
 * @author lianjishu
 * @since 2026-07-16
 */
public class ExerciseC {

    /**
     * 构造 mock 数据：使用你提供的 9 个人名 + 出生日期。
     *
     * <p>
     * 包含：
     * <ul>
     * <li>姓名末尾空格 "Sweetie Fox "、中间双空格 "Dainty wilder"、全小写 "comatozze"、"vanessa
     * alessia"、"cutie kim" 等细节，原样保留</li>
     * <li>一条完全重复 ("Polly Yangs", 2004-08-11) 验证去重</li>
     * </ul>
     *
     * @return 排序并去重后的 TreeSet
     */
    private static TreeSet<Student> getMockData() {
        TreeSet<Student> students = new TreeSet<>();
        students.add(new Student("Sweetie Fox ", LocalDate.of(2001, 6, 25)));
        students.add(new Student("Diana Rider", LocalDate.of(2003, 8, 27)));
        students.add(new Student("Comatozze", LocalDate.of(2004, 11, 27)));
        students.add(new Student("Polly Yangs", LocalDate.of(2004, 8, 11)));
        students.add(new Student("Vanessa Alessia", LocalDate.of(2004, 2, 20)));
        students.add(new Student("Cutie Kim", LocalDate.of(2003, 3, 1)));
        students.add(new Student("Dainty Wilder", LocalDate.of(2001, 9, 28)));
        students.add(new Student("Sierra Cute", LocalDate.of(2001, 1, 15)));
        students.add(new Student("Bella Spark", LocalDate.of(2000, 8, 11)));
        students.add(new Student("Jia lissa", LocalDate.of(1996, 9, 1)));
        students.add(new Student("Polly Yangs", LocalDate.of(2004, 8, 11))); // 完全重复，验证去重
        return students;
    }

    public static void main(String[] args) {
        TreeSet<Student> students = getMockData();
        System.out.println("=== TreeSet 排序结果 ===");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("\n共 " + students.size() + " 条记录");
    }
}