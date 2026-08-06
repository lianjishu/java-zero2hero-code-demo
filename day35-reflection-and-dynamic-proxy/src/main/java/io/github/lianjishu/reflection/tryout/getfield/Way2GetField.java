package io.github.lianjishu.reflection.tryout.getfield;

import java.lang.reflect.Field;
import io.github.lianjishu.reflection.tryout.getconstructor.User;

/**
 * Class类中用于获取成员变量的方法
 * Field[] getFields(): 返回所有公共成员变量对象的数组
 * Field[] getDeclaredFields(): 返回所有成员变量对象的数组
 * Field getField(String name): 返回单个公共成员变量对象
 * Field getDeclaredField(String name): 返回单个成员变量对象
 * 
 * 
 * Field类中用于操作成员变量值的方法
 * void set(Object obj, Object value): 赋值
 * Object get(Object obj) 获取值
 */
public class Way2GetField {
    public static void main(String[] args) throws Exception {
        // 衔接一下getConstructor里的例子
        // 来个Class对象
        Class<?> userClazz = Class.forName("io.github.lianjishu.reflection.tryout.getconstructor.User");
        // 反射获取Constructor 然后创建User对象
        User shuwenjie = (User) userClazz
                .getConstructor(
                        String.class,
                        String.class,
                        int.class)
                .newInstance(
                        "C202414040247",
                        "舒文杰",
                        20);

        // 1. 改 public 字段
        // ...
        // 2. 改 private 字段 —— 必须 setAccessible(true)
        Field idField = userClazz.getDeclaredField("id");
        idField.setAccessible(true); // ← 关键：绕过 private
        System.out.println(idField.get(shuwenjie));

        Field nameField = userClazz.getDeclaredField("name");
        nameField.setAccessible(true);
        System.out.println(nameField.get(shuwenjie));

        Field ageField = userClazz.getDeclaredField("age");
        ageField.setAccessible(true);
        System.out.println(ageField.get(shuwenjie));
        System.out.println("=========================\n");

        // 3. 一次性打印所有本类声明的字段（含 private）
        Field[] declarFields = userClazz.getDeclaredFields();
        for(var s: declarFields){
            System.out.println(s);
        }
    }
}
