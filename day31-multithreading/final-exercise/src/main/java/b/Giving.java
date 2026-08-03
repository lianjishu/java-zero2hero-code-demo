package b;

import java.util.concurrent.atomic.AtomicInteger;

public class Giving implements Runnable {

    private AtomicInteger giftCnt = null;

    public Giving(int giftCnt) {
        this.giftCnt = new AtomicInteger(giftCnt);
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        while (true) {
            int decremented = giftCnt.decrementAndGet();
            if (decremented < 10) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "赠送成功!!!" + " 剩余" + decremented);
        }

    }
}
