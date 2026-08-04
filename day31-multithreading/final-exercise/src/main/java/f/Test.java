package f;

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
public class Test {
    public static void main(String[] args) {
        int[] prizes = {10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700};
        PrizePool pool = new PrizePool(prizes);
        EnhancedRaffleDraw draw1 = new EnhancedRaffleDraw(pool);
        EnhancedRaffleDraw draw2 = new EnhancedRaffleDraw(pool);

        Thread t1 = new Thread(draw1, "抽奖箱1");
        Thread t2 = new Thread(draw2, "抽奖箱2");

        t1.start();
        t2.start();
    }
}
