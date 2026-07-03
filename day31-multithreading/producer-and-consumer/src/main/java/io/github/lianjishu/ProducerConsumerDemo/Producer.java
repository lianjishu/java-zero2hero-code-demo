package io.github.lianjishu.ProducerConsumerDemo;

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

    @Override
    public void run() {
        while(true) {
            synchronized (Desk.lock) {
                if(Desk.count <= 0) {
                    System.out.println(Thread.currentThread().getName() + " - 10次数已用完! 程序退出...");
                    break;
                }else {
                    if(Desk.foodFlag > 0) {
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else { //Desk.foodFlag equals 0
//                        Desk.count --;
                        System.out.println(
                                Thread.currentThread().getName()+
                                " - " +
                                "金牌厨师长出餐中..." + "已做" + (10-Desk.count+1) + "份"

                        );
                        Desk.foodFlag = 1;
                        Desk.lock.notifyAll();
                    }
                }
            }
        }
    }
}

