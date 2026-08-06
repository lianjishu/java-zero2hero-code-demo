package io.github.lianjishu.reflection.tryout.getclazz;

public class Way2GetClazz {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1.用包名+类名
        Class<?> clazz1 = Class.forName("io.github.lianjishu.reflection.tryout.getclazz.Student");
        // 2.用类名
        Class<?> clazz2 = Student.class;
        // 3.用类实例
        Student s = new Student("李华", 21);
        Class<?> clazz3 = s.getClass();

        System.out.println(clazz1);
        System.out.println(clazz2);
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);
    }
}
