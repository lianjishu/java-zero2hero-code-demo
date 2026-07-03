package io.github.lianjishu.ShowDeadLock;

public class ThreadAB implements Runnable {
    public static final Object LockA = new Object();
    public static final Object LockB = new Object();

    @Override
    public void run() {
        while (true) {
            if ("threadA".equals(Thread.currentThread().getName())) {
                synchronized (LockA) {
                    System.out.println("threadA拿到A锁, 准备拿B锁");
                    synchronized (LockB) {
                        System.out.println("threadA拿到了B锁");
                        System.out.println("执行任务代码......");
                        System.out.println("任务完成!!!");
                    }
                }
            } else if("threadB".equals(Thread.currentThread().getName())) {
                synchronized (LockB) {
                    System.out.println("threadB拿到B锁, 准备拿A锁");
                    synchronized (LockA) {
                        System.out.println("threadB拿到了A锁");
                        System.out.println("执行任务代码......");
                        System.out.printf("任务完成!!!");
                    }
                }
            }
        }
    }
}
