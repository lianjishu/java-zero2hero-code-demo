package ComprehensivePracticalExercises.TicketSeller.UseArrayBlockingQueue;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Test {
    private final static int CAPACITY = 1000;
    public static void main(String[] args) {

        ArrayList<Ticket> ticketList = Ticket.TicketGenerater();

        ArrayBlockingQueue<Ticket> q = new ArrayBlockingQueue<>(
                1000,
                false,
                ticketList
        );
        Thread ticketWindow1 = new Thread(new TicketWindow(q));
        Thread ticketWindow2= new Thread(new TicketWindow(q));

        ticketWindow1.start();
        ticketWindow2.start();
    }
}
