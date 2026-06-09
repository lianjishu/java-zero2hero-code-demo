public class TestTicketSellerSync {
    private static void testTicketSellerSync() {
        Thread t1 = new Thread(new TicketSellerSync());
        Thread t2 = new Thread(new TicketSellerSync());
        Thread t3 = new Thread(new TicketSellerSync());
        Thread t4 = new Thread(new TicketSellerSync());
        Thread t5 = new Thread(new TicketSellerSync());
        Thread t6 = new Thread(new TicketSellerSync());
        Thread t7 = new Thread(new TicketSellerSync());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
    }

    public static void main(String[] args) {
        TestTicketSellerSync.testTicketSellerSync();
    }
}
