package f;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 奖池类 - 管理所有奖项
 */
public class PrizePool {
    private List<Integer> prizeList;
    private final Random random;

    public PrizePool(int[] prizes) {
        random = new Random();
        prizeList = new ArrayList<>();
        for (int j : prizes) {
            prizeList.add(j);
        }
    }

    /**
     * 随机抽取一个奖项
     *
     * @return 抽取的奖项，如果没有奖项则返回null
     */
    public synchronized Integer drawPrize() {
        // 检查是否还有奖项
        if (prizeList.isEmpty()) {
            return null;
        }

        // 随机生成索引
        int index = random.nextInt(prizeList.size());
        // 获取并移除该奖项
        Integer prize = prizeList.remove(index);

        return prize;
    }

    /**
     * 检查奖池是否为空
     */
    public synchronized boolean isEmpty() {
        return prizeList.isEmpty();
    }
}
