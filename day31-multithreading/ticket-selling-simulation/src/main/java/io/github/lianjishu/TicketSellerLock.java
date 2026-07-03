package io.github.lianjishu;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketSellerLock implements Runnable {
    public static Lock lock = new ReentrantLock();

    public void run() {
        // TicketSellerLock.toRunFoo();
        TicketSellerLock.toRunBar();
    }

    private static void toRunFoo() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            synchronized (TicketPool.class) {
            //阻塞等待
            // ... ...
            TicketSellerLock.lock.lock();

            //临界区
            if (!TicketPool.isEmpty()) {
                //一次取一张
                int next = TicketPool.getTickets().size() - TicketPool.getRemaining();
                TicketPool.setRemaining(TicketPool.getRemaining() - 1);
                System.out.println(String.format("%s : \"%s\"已售出, 余票数: %s",
                        Thread.currentThread().getName(),
                        TicketPool.getTickets().get(next).toString(),
                        TicketPool.getRemaining()
                ));
            } else {
                TicketSellerLock.lock.unlock();
                break;
            }

            //唤醒等待
            // ... ...
            TicketSellerLock.lock.unlock();
        }
    }

    // try-catch-finally 包裹 Lock
    private static void toRunBar() {
        while (true) {
            try {
                Thread.sleep(100);
                //阻塞等待
                // ... ...
                lock.lock();

                //临界区
                if (!TicketPool.isEmpty()) {
                    //一次取一张
                    int next = TicketPool.getTickets().size() - TicketPool.getRemaining();
                    TicketPool.setRemaining(TicketPool.getRemaining() - 1);
                    System.out.println(String.format("%s : \"%s\"已售出, 余票数: %s",
                            Thread.currentThread().getName(),
                            TicketPool.getTickets().get(next).toString(),
                            TicketPool.getRemaining()
                    ));
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                //唤醒等待
                // ... ...
                lock.unlock();
            }
        }
    }

}
