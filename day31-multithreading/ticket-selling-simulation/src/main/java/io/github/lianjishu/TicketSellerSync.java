package io.github.lianjishu;

public class TicketSellerSync implements Runnable {

    private void runLogic() throws InterruptedException {
        while(true) {

            //互斥锁
            Thread.sleep(100);
            synchronized (TicketPool.class) {
                //阻塞等待
                // ... ...

                //临界区
                if(!TicketPool.isEmpty()) {
                    //一次取一张

                    int next = TicketPool.getTickets().size() - TicketPool.getRemaining();
                    TicketPool.setRemaining(TicketPool.getRemaining()-1);
                    System.out.println(String.format("%s : \"%s\"已售出, 余票数: %s",
                            Thread.currentThread().getName(),
                            TicketPool.getTickets().get(next).toString(),
                            TicketPool.getRemaining()
                    ));
                } else {
                    break;
                }

                //唤醒等待
                // ... ...
            }
        }
    }

    @Override
    public void run() {
        try {
            runLogic();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
