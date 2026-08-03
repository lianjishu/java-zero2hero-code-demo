package c;

import java.awt.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 多线程练习3（打印奇数数字）（学生自己练习）
 * 同时开启两个线程，共同获取1-100之间的所有数字。
 * 要求：将输出所有的奇数。
 */
public class EvenPrinter implements Runnable {
    BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(100);

    {
        for (int i = 1; i <= 100; ++i) {
            bq.offer(i);
        }
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        while (true) {
            Integer num = bq.poll();
            if (num == null) break;
            if (num % 2 != 0) System.out.println(Thread.currentThread().getName() + "-" + num);
        }
    }
}
