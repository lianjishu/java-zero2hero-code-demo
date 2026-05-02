package com.zzy.Runtime.TestRuntime_20260430;

import java.io.IOException;

    /**
      * public static Runtime getRuntime() 当前系统的运行环境对象
      * public void exit(int status) 停止虚拟机
      * public int availableProcessors() 获得CPU的线程数
      * public long maxMemory() JVM能从系统中获取总内存大小(单位byte)
      * public long totalMemory() JVM已经从系统中获取总内存大小(单位byte)
      * public long freeMemory() JVM剩余内存大小(单位byte)
      * public Process exec(String command) 运行cmd命令
     */

public class TestRuntime {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("获得CPU的线程数: ");
        System.out.println(new Runtime.availableProcessors());
    }
}