package a;

/**
 * 多线程练习1（卖电影票）（学生自己练习）
 * 需求：
 * 一共有1000张电影票，可以在两个窗口领取，假设每次领取的时间为3000毫秒，
 * 要求：请用多线程模拟卖票过程并打印剩余电影票的数量
 */
public class TicketSellingSimulation {
    public static void main(String[] args) {
        TicketWindowAbstract ticketWindow = new TicketWindowBlockingQueue();
        Thread window1 = new Thread(ticketWindow);
        Thread window2 = new Thread(ticketWindow);

        window1.start();
        window2.start();
    }

}
