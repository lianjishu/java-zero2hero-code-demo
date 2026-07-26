package methodrefs.exercise.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import methodrefs.exercise.common.Student;

/**
 * 方法引用综合练习 1
 * <p>
 * 集合中存储一些字符串数据，比如：张三,23。
 * <p>
 * 收集到 Student 类型的数组当中（使用方法引用完成）
 */
public class StringToStudentArrayPractice {
    private static ArrayList<String> list = new ArrayList<>();

    static {
        Collections.addAll(
                list,
                "张无忌,15", "周芷若,14", "赵敏,13", "张强,20", "张三丰,100",
                "张翠山,40", "张良,35", "王二麻子,37", "李白,30", "李清照,28",
                "李世民,45", "王安石,50", "王昭君,22", "诸葛亮,54", "司马懿,70",
                "欧阳锋,66", "东方不败,48", "慕容复,29", "小龙女,24", "杨过,25",
                "郭靖,35", "黄蓉,34", "令狐冲,27", "任盈盈,26", "张三,8",
                "张小凡,18", "张天爱,31", "陈近南,60", "林平之,21", "宋青书,23"
        );
    }

    private static Student[] solution() {
        return list.stream()
                .map(Student::new)
                .toArray(Student[]::new);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution()));

    }
}
