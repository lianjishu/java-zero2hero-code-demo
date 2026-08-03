package e;

/**
 * 多线程练习5（抽奖箱抽奖）
 * 有一个抽奖池，该抽奖池中存放了奖励的金额，奖项数组：{10,5,20,50,100,200,500,800,2,80,300,700};
 * 创建两个抽奖箱(线程)，线程名称分别为 "抽奖箱1"，"抽奖箱2"
 * 随机从抽奖池中获取奖项元素并打印在控制台上，每次抽出一个奖项就打印一个(随机)
 * 输出格式示例：
 * 抽奖箱1又产生了一个 10 元大奖
 * 抽奖箱1又产生了一个 100 元大奖
 */
public class RaffleDraw implements Runnable {
    private PrizePool pool = new PrizePool();

    public RaffleDraw() {
        this.pool = pool;
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

            // 打印抽奖结果
            System.out.println(threadName + "又产生了一个 " + prize + " 元大奖");

            // 模拟抽奖过程，让输出更真实
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
