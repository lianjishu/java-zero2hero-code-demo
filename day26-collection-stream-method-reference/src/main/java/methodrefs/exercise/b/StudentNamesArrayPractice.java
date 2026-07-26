package methodrefs.exercise.b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import methodrefs.exercise.common.Student;

/**
 * 方法引用综合练习 2
 * <p>
 * 创建集合添加学生对象，学生对象属性：name，age
 * <p>
 * 只获取姓名并放到数组当中（使用方法引用完成）
 */
public class StudentNamesArrayPractice {
    private static ArrayList<Student> students = new ArrayList<>();

    static {
        Collections.addAll(
                students,
                new Student("张无忌", 15),
                new Student("周芷若", 14),
                new Student("张三丰", 100),
                new Student("王二麻子", 37),
                new Student("李清照", 28),
                new Student("诸葛亮", 54),
                new Student("欧阳锋", 66),
                new Student("张三", 8),
                new Student("张小凡", 1)
        );
    }

    private static String[] solution() {
        return students.stream()
                .map(Student::getName)
                .toArray(String[]::new);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution()));
    }
}
