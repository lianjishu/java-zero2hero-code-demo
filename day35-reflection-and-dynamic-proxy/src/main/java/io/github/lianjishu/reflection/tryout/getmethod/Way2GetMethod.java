package io.github.lianjishu.reflection.tryout.getmethod;

import java.lang.reflect.Method;
import io.github.lianjishu.reflection.tryout.getconstructor.User;

/**
 * Way2GetMethod
 * 利用反射获取成员方法
 * 
 * Class类中用于获取成员方法的方法
 * Method[] getMethods(): 返回所有公共成员方法对象的数组，包括继承的
 * Method[] getDeclaredMethods(): 返回所有成员方法对象的数组，不包括继承的
 * Method getMethod(String name, Class<?>... parameterTypes): 返回单个公共成员方法对象
 * Method getDeclaredMethod(String name, Class<?>... parameterTypes): 返回单个成员方法对象
 * 
 * Method类中用于创建对象的方法
 * Object invoke(Object obj, Object... args): 运行方法
 * 参数一: 用obj对象调用该方法
 * 参数二: 调用方法的传递的参数（如果没有就不写）
 * 返回值: 方法的返回值（如果没有就不写）
 * 
 */
public class Way2GetMethod {
    public static void main(String[] args) throws Exception {
        // 0. 从0开始, 反射三件套第一步拿到Class对象
        Class<?> userClazz = Class.forName("io.github.lianjishu.reflection.tryout.getconstructor.User");
        // 创建User对象
        User shuwenjie = (User) userClazz
                .getConstructor(
                        String.class,
                        String.class,
                        int.class)
                .newInstance(
                        "C202414040247",
                        "舒文杰",
                        20);

        // 1. 调 public 方法
        Method sayHelloMethod = userClazz.getMethod("sayHello");
        sayHelloMethod.invoke(shuwenjie);
        Method workMethod = userClazz.getMethod("work", String.class);
        workMethod.invoke(shuwenjie, "打王者");

        // 2. 调 private 方法 —— 必须 setAccessible(true)
        Method privateSecretMethod = userClazz.getDeclaredMethod("privateSecret");
        privateSecretMethod.setAccessible(true);
        privateSecretMethod.invoke(shuwenjie);

        // 3. 调 static 方法（obj 传 null）
        Method getCountryMethod = userClazz.getMethod("getCountry");
        getCountryMethod.invoke(null);

        Method privateFormatIdMethod = userClazz.getDeclaredMethod("privateFormatId", String.class);
        privateFormatIdMethod.setAccessible(true);
        String retval = (String) privateFormatIdMethod.invoke(null, "C202414040247");
        System.out.println(retval);
    }
}
