package io.github.lianjishu.ComprehensivePracticalExercises.TicketSeller.UseSynchronized;

public class Test {
    public static void main(String[] args) {
        Thread ticketWindow1 = new Thread(new TicketWindow());
        Thread ticketWindow2 = new Thread(new TicketWindow());

        ticketWindow1.start();
        ticketWindow2.start();
    }
}
