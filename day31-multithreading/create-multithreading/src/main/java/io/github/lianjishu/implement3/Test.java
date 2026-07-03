package io.github.lianjishu.implement3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTask task = new CallableTask();
        FutureTask<Integer> ft = new FutureTask<>(task);
        Thread t1 = new Thread(ft);
        t1.start();

        Integer res = ft.get();
        System.out.println(res);
    }

}
