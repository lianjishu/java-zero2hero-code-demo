public class TicketSeller implements Runnable {

    private void runLogic() {
        while(true) {
            if(!TicketPool.isEmpty()) {
                //一次取一张
                int next = TicketPool.getTickets().size() - TicketPool.getRemaining();
                TicketPool.setRemaining(TicketPool.getRemaining()-1);
                System.out.println(String.format("%s : \"%s\"已售出, 余票数: %s",
                        Thread.currentThread().getName(),
                        TicketPool.getTickets().get(next).toString(),
                        TicketPool.getRemaining()));
            } else {
                break;
            }

        }
    }

    @Override
    public void run() {
        runLogic();
    }

}
