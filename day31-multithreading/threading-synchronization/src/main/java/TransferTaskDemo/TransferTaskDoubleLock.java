package TransferTaskDemo;

public class TransferTaskDoubleLock implements Runnable {
    private Transfer transfer;

    public TransferTaskDoubleLock() {
    }

    public TransferTaskDoubleLock(Transfer transfer) {
        this.transfer = transfer;
    }

    public TransferTaskDoubleLock(Account from, Account to, int amount) {
        this(new Transfer(from, to, amount));
    }

    public void doTransfer() throws InterruptedException {
        Account from = transfer.getFrom();
        Account to = transfer.getTo();
        int amount = transfer.getAmount();
        String threadName = Thread.currentThread().getName();

        synchronized (from) {
            System.out.printf("[%s] 锁住 %s (balance=%d)%n",
                    threadName, from.getName(), from.getBalance());
            Thread.sleep(200);

            synchronized (to) {
                System.out.printf("[%s] 拿到 %s,开始扣减/增加...%n",
                        threadName, to.getName());
                from.setBalance(from.getBalance() - amount);
                to.setBalance(to.getBalance() + amount);
            }
        }
        System.out.printf("[%s] 转账完成: %s=%d, %s=%d%n",
                threadName, from.getName(), from.getBalance(), to.getName(), to.getBalance());
    }

    @Override
    public void run() {
        try {
            doTransfer();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Transfer getTransfer() {
        return transfer;
    }

    public void setTransfer(Transfer transfer) {
        this.transfer = transfer;
    }
}
