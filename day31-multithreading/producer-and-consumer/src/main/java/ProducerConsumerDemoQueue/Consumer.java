package ProducerConsumerDemoQueue;

import org.w3c.dom.css.CSSStyleDeclaration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

/*
**多线程实现思路:
* 1/循环; 2/同步代码块; 3/判断共享数据是否到了末尾(到了末尾); 4/判断共享数据是否到了末尾(没到末尾->执行核心逻辑)
**消费者核心逻辑:
*
* 判断桌子上是否有食物
* 如果没有就等待
  如果有就开吃
* 吃完后喊醒厨师继续做
*/
public class Consumer implements Runnable {
    public ArrayBlockingQueue<String> blockingQueue = null;

    Consumer() {
    }

    Consumer(ArrayBlockingQueue queue) {
        this.blockingQueue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                blockingQueue.put("FOOD");
                System.out.println("厨师长已出餐一份...");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
