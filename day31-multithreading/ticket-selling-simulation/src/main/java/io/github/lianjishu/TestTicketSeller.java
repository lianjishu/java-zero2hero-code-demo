package io.github.lianjishu;

public class TestTicketSeller {

    static void testTicketSeller() {
        Thread t1 = new Thread(new TicketSeller());
        Thread t2 = new Thread(new TicketSeller());
        Thread t3 = new Thread(new TicketSeller());
        Thread t4 = new Thread(new TicketSeller());
        Thread t5 = new Thread(new TicketSeller());
        Thread t6 = new Thread(new TicketSeller());
        Thread t7 = new Thread(new TicketSeller());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
    }


    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "总票数: " + TicketPool.getTickets().size());
         TestTicketSeller.testTicketSeller();
    }

}
