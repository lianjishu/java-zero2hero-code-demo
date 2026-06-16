package ProducerConsumerDemo;

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
    public Consumer() {}

    @Override
    public void run() {
        //1/循环;
        while (true) {
            //2/同步代码块
            synchronized (Desk.lock) {
                //3/判断共享数据是否到了末尾(到了末尾)
                if (Desk.count <= 0) {
                    System.out.println(Thread.currentThread().getName() + " - 10次数已用完! 程序退出...");
                    break;
                }
                //4/判断共享数据是否到了末尾(没到末尾->执行核心逻辑)
                else { //Desk.cnt > 0
                    // 判断桌子上是否有食物 如果没有就等待
                    if (Desk.foodFlag == 0) {
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {// 如果有就开吃
                        Desk.count -- ;
                        System.out.println(Thread.currentThread().getName() + " - "
                                + "顾客开吃开吃..."
                                + "还能吃" + (Desk.count) + "份"
                        );
                        Desk.foodFlag = 0;
                        // 吃完后喊醒厨师继续做
                        Desk.lock.notifyAll();
                    }
                }
            }
        }
    }
}
