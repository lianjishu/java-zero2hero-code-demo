package f;

import java.util.ArrayList;

/**
 * 多线程练习6（多线程统计并求最大值）
 * 在练习5的基础上继续完成需求：
 * 每次抽的过程中，不打印，抽完时一次性打印(随机)
 * 示例输出：
 * 在此次抽奖过程中，抽奖箱1总共产生了6个奖项。
 * 分别为：10,20,100,500,2,300 最高奖项为300元，总计额为932元
 * 在此次抽奖过程中，抽奖箱2总共产生了6个奖项。
 * 分别为：5,50,200,800,80,700 最高奖项为800元，总计额为1835元
 */
public class EnhancedRaffleDraw implements Runnable {
    private final PrizePool pool;
    private ArrayList<Integer> raffleRecord;

    public EnhancedRaffleDraw(PrizePool pool) {
        raffleRecord = new ArrayList<>();
        this.pool = pool;
    }

    public ArrayList<Integer> getRaffleRecord() {
        return raffleRecord;
    }

    public void setRaffleRecord(ArrayList<Integer> raffleRecord) {
        this.raffleRecord = raffleRecord;
    }

    private int[] getSumAndMax() {
        int[] sumAndMax = new int[]{0, Integer.MIN_VALUE};
        for (var e : raffleRecord) {
            sumAndMax[1] = sumAndMax[1] > e ? sumAndMax[1] : e;
            sumAndMax[0] += e;
        }
        return sumAndMax;
    }

    @Override
    public void run() {
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

    }

}
