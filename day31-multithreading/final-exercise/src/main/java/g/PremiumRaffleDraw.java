package g;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 * 多线程练习7（多线程之间的比较）
 * 在练习6的基础上继续完成需求：
 * 在此次抽奖过程中，抽奖箱1总共产生了6个奖项，分别为：10,20,100,500,2,300
 * 最高奖项为300元，总计额为932元
 * 在此次抽奖过程中，抽奖箱2总共产生了6个奖项，分别为：5,50,200,800,80,700
 * 最高奖项为800元，总计额为1835元
 * 在此次抽奖过程中,抽奖箱2中产生了最大奖项,该奖项金额为800元
 * 备注：以上打印效果只是数据模拟,实际代码运行的效果会有差异
 */
public class PremiumRaffleDraw implements Callable<Integer> {
    private final PrizePool pool;
    private ArrayList<Integer> raffleRecord;

    public PremiumRaffleDraw(PrizePool pool) {
        raffleRecord = new ArrayList<>();
        this.pool = pool;
    }

    public ArrayList<Integer> getRaffleRecord() {
        return raffleRecord;
    }

    public void setRaffleRecord(ArrayList<Integer> raffleRecord) {
        this.raffleRecord = raffleRecord;
    }

    public int[] getSumAndMax() {
        int[] sumAndMax = new int[]{0, Integer.MIN_VALUE};
        for (var e : raffleRecord) {
            sumAndMax[1] = sumAndMax[1] > e ? sumAndMax[1] : e;
            sumAndMax[0] += e;
        }
        return sumAndMax;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        // 获取当前线程名称
        String threadName = Thread.currentThread().getName();

        // 持续抽奖，直到奖池为空
        while (true) {
            // 从奖池中抽取奖项
            Integer prize = pool.drawPrize();

            // 如果抽到的奖项为null，说明奖池已空，退出循环
            if (prize == null) {
                System.out.println(threadName + " 奖池已空，停止抽奖！");
                break;
            }

            // 做记录 不打印抽奖结果
            //System.out.println(threadName + "又产生了一个 " + prize + " 元大奖");
            raffleRecord.add(prize);

            // 模拟抽奖过程，让输出更真实
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println("在此次抽奖过程中，" + threadName + "总共产生了6个奖项。");
        int[] sumAndMax = getSumAndMax();
        System.out.println("分别为:" + raffleRecord + "最高奖项为" + sumAndMax[1] + "元，总计额为" + sumAndMax[0] + "元");

        return getSumAndMax()[1];
    }
}
