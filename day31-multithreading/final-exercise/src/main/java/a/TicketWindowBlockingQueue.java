package a;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TicketWindowBlockingQueue extends TicketWindowAbstract {
    private final int ticketCnt = 1000;
    private final BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(ticketCnt);

    {
        for (int i = 1; i <= ticketCnt; ++i) {
            bq.offer(i);
        }
    }

    @Override
    //卖票
    public void run() {
        while (true) {
            //poll
            Integer ticket = bq.poll();
            if (ticket == null) break;// 没票了，退出
            System.out.println(Thread.currentThread().getName() + "-售票成功! 剩余" + bq.size() + "张");
        }
    }

}
