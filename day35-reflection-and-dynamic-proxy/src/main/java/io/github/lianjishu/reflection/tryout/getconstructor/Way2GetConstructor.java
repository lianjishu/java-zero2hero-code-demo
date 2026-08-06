package io.github.lianjishu.reflection.tryout.getconstructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Class类中用于获取构造方法的方法
 * Constructor<?>[] getConstructors()
 * Constructor<?>[] getDeclaredConstructors()
 * Constructor<T> getConstructor(Class<?>... parameterTypes)
 * Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)
 * 
 * 
 * Constructor类中用于创建对象的方法
 * T newInstance(Object... initargs)
 * setAccessible(boolean flag)
 */
public class Way2GetConstructor {
    public static void main(String[] args)
            throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException,
            SecurityException {

        // 来个Class对象
        Class<?> clazz = Class.forName("io.github.lianjishu.reflection.tryout.getconstructor.User");

        // 1.拿public-modified无参构造
        Constructor<?> c1 = clazz.getConstructor();
        User u1 = (User) c1.newInstance();

        // 2. 拿 public-modified 有参构造
        Constructor<?> c2 = clazz.getConstructor(String.class, String.class, int.class);
        User u2 = (User) c2.newInstance("43021248", "张三", 47);

        // 3. 拿 private-modified 构造 → 必须 setAccessible(true)
        Constructor<?> c3 = clazz.getDeclaredConstructor(String.class);
        c3.setAccessible(true); // 暴力反射
        User u3 = (User) c3.newInstance("汪汪的汪尿");
    }
}
