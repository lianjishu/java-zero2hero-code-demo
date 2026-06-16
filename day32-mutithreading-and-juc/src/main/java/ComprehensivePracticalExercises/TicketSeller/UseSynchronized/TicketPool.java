package ComprehensivePracticalExercises.TicketSeller.UseSynchronized;

import java.util.ArrayList;

public class TicketPool {
    public static void setRemaining(int remaining) {
        TicketPool.remaining = remaining;
    }

    public static int getRemaining() {
        return remaining;
    }

    private static int remaining = 1000;

    private int current;

    private static final Object lock = new Object();

//    TicketPool() {
//        remaining = 1000;
//    }

    public static int getCurrent() {
        return TicketPool.getTicketList().size() - TicketPool.remaining;
    }


    public static int getCount() {
        return TicketPool.remaining;
    }

    public static Object getLock() {
        return TicketPool.lock;
    }

    private static final ArrayList<Ticket> tickets = Ticket.TicketGenerater();

    public static ArrayList<Ticket> getTicketList() {
        return tickets;
    }
}
