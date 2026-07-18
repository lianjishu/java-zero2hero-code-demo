package map.treemap.treemapExercise;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// 案例需求
//+ 创建一个TreeMap集合,键是学生对象(Student),值是籍贯(String),学生属性姓名和年龄,按照年龄进行排序并遍历
//+ 要求按照学生的年龄进行排序,如果年龄相同则按照姓名进行排序
public class TreeMapExercise {
    public static void main(String[] args) {
        Student[] students = new Student[]{
                new Student("张三", "001", 19),
                new Student("李四", "002", 28),
                new Student("王五", "006", 18)
        };
        Map<Student, String> map = new TreeMap<>();
        map.put(students[0], "北京");
        map.put(students[1], "上海");
        map.put(students[2], "广州");

        Set<Map.Entry<Student, String>> entries = map.entrySet();
        entries.forEach(
                kv -> System.out.printf("\"%s\": \"%s\"%n",
                        kv.getKey(),
                        kv.getValue())
        );
    }

}
