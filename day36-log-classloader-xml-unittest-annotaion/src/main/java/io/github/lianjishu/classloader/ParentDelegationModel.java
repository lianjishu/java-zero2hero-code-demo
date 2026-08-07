package io.github.lianjishu.classloader;

/*
   ┌─────────────────────────┐
   │      启动类加载器        │
   │  Bootstrap ClassLoader  │
   └────────────△▽───────────┘
                ││
                ││
   ┌────────────▽▽───────────┐
   │      平台类加载器        │
   │  Platform Classloader   │
   └────────────△△───────────┘
                ││
                ││
   ┌────────────▽▽───────────┐
   │      系统类加载器        │
   │   System Classloader    │
   └────────────△△───────────┘
                ││
                ││
   ┌────────────▽▽───────────┐
   │     自定义类加载器       │
   │     UserClassloader     │
   └─────────────────────────┘
 */
public class ParentDelegationModel {
    public static void main(String[] args) {
        // 获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        // 向上获取 | 得到平台类加载器
        ClassLoader platformClassLoader = systemClassLoader.getParent();
        // 向上获取 | 得到启动类加载器
        ClassLoader bootstrapClassLoader = platformClassLoader.getParent();

        System.out.println("系统类加载器: " + systemClassLoader);
        System.out.println("平台类加载器: " + platformClassLoader);
        System.out.println("启动类加载器: " + bootstrapClassLoader);
    }

}
