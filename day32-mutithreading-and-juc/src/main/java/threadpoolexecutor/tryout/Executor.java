package threadpoolexecutor.tryout;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    public static ExecutorService newCachedThreadPool()                创建一个没有上限的线程池
    public static ExecutorService newFixedThreadPool (int nThreads)    创建有上限的线程池
 */
public class Executor {

    public static void main(String[] args) {
        //1.获取线程池对象
        ExecutorService pool1 = Executors.newFixedThreadPool(2);
        //2.提交任务
        // MyRunnable runnableTask = new MyRunnable();

        pool1.submit(new MyRunnable()); //1

        pool1.submit(new MyRunnable()); //2
       
        pool1.submit(new MyRunnable()); //3
       
        pool1.submit(new MyRunnable()); //4

        pool1.submit(new MyRunnable()); //5

        pool1.submit(new MyRunnable()); //6

        pool1.submit(new MyRunnable()); //7
       
        //3.销毁线程池 | 一般不销毁
        // pool1.shutdown();
    }
}
