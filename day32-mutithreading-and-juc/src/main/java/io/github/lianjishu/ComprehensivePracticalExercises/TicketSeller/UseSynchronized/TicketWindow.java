package io.github.lianjishu.ComprehensivePracticalExercises.TicketSeller.UseSynchronized;

public class TicketWindow implements Runnable {
//    TicketPool ticketPool = null;

    TicketWindow() {
    }

//    TicketWindow(TicketPool pool) {
//        this.ticketPool = pool;
//    }

    @Override
    public void run() {
        while (true) {
            synchronized (TicketPool.getLock()) {
                if (TicketPool.getRemaining() > 0) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.printf("[%s] - %s-%s已售出... 余票: %d张\n",
                            Thread.currentThread().getName(),
                            TicketPool.getTicketList().get(TicketPool.getCurrent()).getId(),
                            TicketPool.getTicketList().get(TicketPool.getCurrent()).getMovieName(),
                            TicketPool.getRemaining()
                    );
                    TicketPool.setRemaining(TicketPool.getRemaining() - 1);
                } else {
                    break;
                }
            }
        }
    }
}
