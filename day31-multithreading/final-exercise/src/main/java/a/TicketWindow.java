package a;

public class TicketWindow extends TicketWindowAbstract {
    private int ticketCnt = 1000;

    @Override
    //卖票
    public void run() {
        while (ticketCnt > 0) {
            synchronized (this) {
                if (ticketCnt <= 0) {
                    break;
                }
                ticketCnt--;
                System.out.println(Thread.currentThread().getName() + "-售票成功! 剩余" + ticketCnt + "张");
            }
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
