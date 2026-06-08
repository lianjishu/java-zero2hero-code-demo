//import java.util.ArrayList;

public class TicketWindow implements Runnable {

    private void runLogic() {
        while(true) {
            //P操作
            if(TicketPool.getRemaining() > 0) {
                for (Ticket t : TicketPool.getTickets()) {
                    TicketPool.setRemaining(TicketPool.getRemaining()-1);
                    System.out.println(
                            Thread.currentThread().getName() + ": " + "售卖" + t.getId()
                    );
                }
            } else {
                break;
            }
            //临界区
            //V操作

        }
    }

    @Override
    public void run() {
        runLogic();
    }

}
