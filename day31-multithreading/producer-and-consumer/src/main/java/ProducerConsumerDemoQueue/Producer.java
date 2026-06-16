package ProducerConsumerDemoQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 生产者
 * 判断桌子上是否有食物
 * 有: 等待
 * 没有: 制作食物
 * 把食物放在桌子上
 * 叫醒等待的消费者开吃
 */
public class Producer implements Runnable {
    //1/循环; 2/同步代码块; 3/判断共享数据是否到了末尾(到了末尾); 4/判断共享数据是否到了末尾(没到末尾->执行核心逻辑)

    public ArrayBlockingQueue<String> blockingQueue = null;

    Producer() {
    }

    Producer(ArrayBlockingQueue queue) {
        this.blockingQueue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                blockingQueue.take();
                System.out.println("已食用一份...");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}