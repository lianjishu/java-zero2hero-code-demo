package io.github.lianjishu.ComprehensivePracticalExercises.PresentGifts;

public class Giver implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (GiftPool.lock) {
                if (GiftPool.getSignal() <= 0) {
                    System.out.println("[" + Thread.currentThread().getName() + "] - " + "礼物数量少于10份, 退出赠送...");
                    GiftPool.lock.notifyAll();
                    break;
                }
                // if: GiftPool.getSignal() > 0
                GiftPool.setCount(GiftPool.getCount() - 1);
                System.out.printf(
                        "[%s] - 礼物🎁赠送成功! 剩余:%d份\n",
                        Thread.currentThread().getName(),
                        GiftPool.getCount()
                );
                //当前线程等待, 自动释放锁给其他的线程使用
                try {
                    GiftPool.lock.wait(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

}
