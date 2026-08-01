package serialization.exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 需求:
 * 将多个自定义对象序列化到文件中，但是对象的个数不确定，该如何操作呢?
 */
public class SerializationExercise {
    public static void main(String[] args) throws IOException {
        serialize();
        deserialize();
    }

    private static void deserialize() throws IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("day29-buffered-io-serialization/src/main/java/serialization/exercise/SERIALZATION.txt"));
        try (ois) {
            ArrayList<Student> o = (ArrayList<Student>) ois.readObject();
            System.out.println(o);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static void serialize() throws IOException {
        //1.序列化多个对象
        Student s1 = new Student("zhangsan", 23, "南京");
        Student s2 = new Student("lisi", 24, "重庆");
        Student s3 = new Student("wangwu", 25, "北京");

        ArrayList<Student> al = new ArrayList<>();
        Collections.addAll(al, s1, s2, s3);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
                "day29-buffered-io-serialization/src/main/java/serialization/exercise/SERIALZATION.txt"
        ));
        try (oos) {
            oos.writeObject(al);
        }
    }
}
