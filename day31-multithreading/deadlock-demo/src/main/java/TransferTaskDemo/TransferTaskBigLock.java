package TransferTaskDemo;

/**
 *   时间线(一把大锁)
 *
 *   时间   T-AtoB                          T-BtoA
 *   ──────────────────────────────────────────────────
 *   t1     🔒 抢锁成功 ✔
 *   t2     读 alice=1000
 *   t3     写 alice=800
 *   t4     读 bob=1000
 *   t5     写 bob=1200
 *   t6     🔒 释放
 *   t7                                     🔒 抢锁成功 ✔
 *   t8                                     读 bob=1200
 *   t9                                     写 bob=1000
 *   t10                                    读 alice=800
 *   t11                                    写 alice=1000
 *   t12                                    🔒 释放
 */
public class TransferTaskBigLock implements Runnable {
    private Transfer transfer;

    public TransferTaskBigLock() {
    }

    public TransferTaskBigLock(Transfer transfer) {
        this.transfer = transfer;
    }

    public TransferTaskBigLock(Account from, Account to, int amount) {
        this(new Transfer(from, to, amount));
    }

    public void doTransfer() throws InterruptedException {
        Account from = transfer.getFrom();
        Account to = transfer.getTo();
        int amount = transfer.getAmount();
        String threadName = Thread.currentThread().getName();

        synchronized (TransferTaskBigLock.class) {
            System.out.printf("[%s] 锁住 %s (balance=%d)%n",
                    threadName, "TransferTaskBigLock.class", from.getBalance());
            Thread.sleep(200);


            System.out.printf("[%s] 拿到 %s,开始扣减/增加...%n",
                    threadName, to.getName());
            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);

            System.out.printf("[%s] 转账完成: %s=%d, %s=%d%n",
                    threadName, from.getName(), from.getBalance(), to.getName(), to.getBalance());
        }
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
