package b;

/**
 * 多线程练习2（送礼品）（学生自己练习）
 * 有100份礼品，两人同时发送，当剩下的礼品小于10份的时候则不再送出。
 * 利用多线程模拟该过程并将线程的名字和礼物的剩余数量打印出来。
 */
public class GiftGivingSimulation {

    public static void main(String[] args) {
        Giving giving = new Giving(100);
        Thread p1 = new Thread(giving);
        Thread p2 = new Thread(giving);
        p1.start();
        p2.start();
    }
}
