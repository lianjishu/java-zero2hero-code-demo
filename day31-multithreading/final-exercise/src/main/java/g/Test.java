package g;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] prizes = {10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700};
        PrizePool pool = new PrizePool(prizes);
        PremiumRaffleDraw draw1 = new PremiumRaffleDraw(pool);
        PremiumRaffleDraw draw2 = new PremiumRaffleDraw(pool);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> f1 = executor.submit(draw1);
        Future<Integer> f2 = executor.submit(draw2);

        Integer res1 = f1.get();
        Integer res2 = f2.get();

        executor.shutdown();
        if (res1 > res2)
            System.out.println("在此次抽奖过程中," + "抽奖箱1" + "中产生了最大奖项,该奖项金额为" + res1 + "元");
        else
            System.out.println("在此次抽奖过程中," + "抽奖箱2" + "中产生了最大奖项,该奖项金额为" + res2 + "元");
    }
}
