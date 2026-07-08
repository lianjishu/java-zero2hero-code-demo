package io.github.lianjishu;

import java.util.Random;

public class Helper {
     public int[] getScrambleArr(int length) {
        //遍历数组每一个元素, 对当前元素与一个随机索引的元素交换
        Random random = new Random();
        int[] indexs = new int[length];
        for(int i=0; i<length; ++i) {
            indexs[i] = i;
        }
        for(int i=0; i<indexs.length; ++i) {
            int rIdx = random.nextInt(indexs.length);
            var tmp = indexs[i];
            indexs[i] = indexs[rIdx];
            indexs[rIdx] = tmp;
        }
        return indexs;
    }
}
