package d;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 多线程练习4（抢红包）
 * 抢红包也用到了多线程。
 * 假设：100块，分成了3个包，现在有5个人去抢。
 * 其中，红包是共享数据。
 * 5个人是5条线程。
 * 打印结果格式：
 * XXX抢到了XXX元
 * XXX抢到了XXX元
 * XXX抢到了XXX元
 * XXX没抢到
 * XXX没抢到
 */
public class GrabbingRedPackets implements Runnable {
    private final BlockingQueue<Integer> preAllocated = new ArrayBlockingQueue<>(3);

    public GrabbingRedPackets() {
        //100块分成3个包, 金额怎么分...
        //原则 1.每人至少拿到0.01元, 每人金额随机 2.每个包的金额加起来一定等于总额
        //二倍均值策略:
        //  随机范围
        //     本次最大金额=(剩余金额/剩余包数)*2
        //     本次金额=Random(0.01, 最大金额)

        int totalPacket = 3;
        int remainCount = 3;//剩余3个包
        int remainMoney = 10000;//剩余金额10000分
        Random r = new Random();

        for (int i = 0; i < totalPacket - 1; ++i) {
            int max = (remainMoney / remainCount) * 2; //本次最大金额=(剩余金额/剩余人数)*2
            int money = r.nextInt(max) + 1;
            remainMoney -= money;
            remainCount--;
            preAllocated.offer(money);
        }
        preAllocated.offer(remainMoney);
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        Integer packetAmount = preAllocated.poll();
        if (packetAmount == null) {
            System.out.printf("%s没抢到%n", Thread.currentThread().getName());
            return;
        }
        System.out.printf("%s抢到了%.2f元%n", Thread.currentThread().getName(), packetAmount / 100.0);
    }
}
