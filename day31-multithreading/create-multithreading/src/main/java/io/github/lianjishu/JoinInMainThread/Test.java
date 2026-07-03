package io.github.lianjishu.JoinInMainThread;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Thread stfoo = new Thread(new SubThreadFoo());
        System.out.println(mainThread.getName() + ": Running...");
        stfoo.start();
        stfoo.join();
        for (int i = 0; i < 10; i++) {
            System.out.println(mainThread.getName() + ": Running...");
        }
    }
}
