package io.github.lianjishu.ProducerConsumerDemoQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Test {
    public static void main(String[] args) {

        var q = new ArrayBlockingQueue<>(1);
        Thread consumer = new Thread(new Consumer(q));
        Thread producer = new Thread(new Producer(q));
        consumer.start();producer.start();
    }
}
