package io.github.lianjishu.reflection.exercise.a;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class ReflectionBasedObjectSerialization2File {
    /*
     * 对于任意一个对象, 都可以把对象所有的字段名和值保存到文件里面去
     */
    public static void main(String[] args)
            throws IllegalArgumentException, IllegalAccessException, IOException {
        Student s = new Student("小A", 23, '女', 167.5, "睡觉");
        Teacher t = new Teacher("波妞", 10000);

        reflectionBasedSaveObjetct(s);

        // reflectionBasedSaveObjetct(t);

    }

    private static void reflectionBasedSaveObjetct(Object o)
            throws IllegalArgumentException, IllegalAccessException, IOException {
        // 获取Class对象
        Class<?> clazz = o.getClass();

        // 创建IO流
        BufferedWriter bw = new BufferedWriter(
                new FileWriter(
                        "E:\\Projects\\Code Demo\\Java\\itheima\\java-zero2hero-code-demo\\day35-reflection-and-dynamic-proxy\\src\\main\\java\\io\\github\\lianjishu\\reflection\\exercise\\a\\object.txt"));

        // 获取所有成员变量
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            // 获取成员变量名字
            String fname = f.getName();
            // 获取成员变量值
            Object fvalue = f.get(o);
            System.out.println(fname + "=" + fvalue);
            // 开写!!!
            bw.write(fname + "=" + fvalue);
            bw.newLine();
        }
        bw.close();
    }
}
