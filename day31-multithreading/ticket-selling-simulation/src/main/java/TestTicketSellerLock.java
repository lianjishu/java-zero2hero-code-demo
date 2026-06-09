import javax.swing.plaf.TableHeaderUI;

public class TestTicketSellerLock {
    private static void testTicketSellerLock() {
        Thread t1 = new Thread(new TicketSellerLock());
        Thread t2 = new Thread(new TicketSellerLock());
        Thread t3 = new Thread(new TicketSellerLock());
        Thread t4 = new Thread(new TicketSellerLock());
        Thread t5 = new Thread(new TicketSellerLock());
        Thread t6 = new Thread(new TicketSellerLock());
        Thread t7 = new Thread(new TicketSellerLock());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();

    }

    public static void main(String[] args) {
        System.out.println(String.format("%s : 总票数: %s", Thread.currentThread().getName(), TicketPool.getTickets().size()));

        TestTicketSellerLock.testTicketSellerLock();
    }
}
