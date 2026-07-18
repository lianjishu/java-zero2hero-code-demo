package map.hashmap.hashmapExercise;

//案例需求
//创建一个HashMap集合，键是学生对象(Student)，
//值是居住地(String)。存储多个元素，并遍历。
//要求保证键的唯一性：如果学生对象的成员变量值相同，我们就认为是同一个对象

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapExercise {
    public static void main(String[] args) {
        Student[] students = new Student[]{
                new Student("张三", "001"),
                new Student("李四", "002"),
                new Student("王五", "006")
        };
        Map<Student, String> map = new HashMap<>();
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
