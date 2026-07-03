package io.github.lianjishu.ComprehensivePracticalExercises.TicketSeller.UseArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class TicketWindow implements Runnable {

    ArrayBlockingQueue<Ticket> bq = null;

    TicketWindow() {

    }

    TicketWindow(ArrayBlockingQueue<Ticket> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        while (bq != null) {
            Ticket front = bq.poll();
            if (front == null) break;
            System.out.printf("[%s] - %s-%s已售出... 余票: %d张\n",
                    Thread.currentThread().getName(),
                    front.getId(),
                    front.getMovieName(),
                    bq.size()
            );
        }
    }
}
