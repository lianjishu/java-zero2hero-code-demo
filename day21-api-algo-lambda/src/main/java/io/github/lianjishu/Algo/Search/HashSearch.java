package io.github.lianjishu.Algo.Search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 哈希查找（Hash Search）.
 *
 * 思路：通过一次遍历构建 value -> index 的哈希映射，
 * 之后每次查找平均时间复杂度降至 O(1).
 * 适用于不需要数据有序，但需要频繁查找的场景；
 * 代价是额外 O(n) 的存储空间.
 */
public class HashSearch implements SearchStrategy {

    @Override
    public String name() {
        return "HashSearch";
    }

    /**
     * 基础实现：先一次性构建哈希表，再做单次查找.
     * 平均时间 O(1)，最坏 O(n)（哈希冲突时退化为链表）.
     */
    @Override
    public int doSearch(List<Integer> nums, int target) {
        int n = nums.size();
        if (n == 0) return -1;

        // value -> 首次出现的下标
        Map<Integer, Integer> indexMap = new HashMap<>(n * 2);
        for (int i = 0; i < n; i++) {
            // 重复值仅记录第一次出现的下标
            if (!indexMap.containsKey(nums.get(i))) {
                indexMap.put(nums.get(i), i);
            }
        }

        Integer res = indexMap.get(target);
        return res == null ? -1 : res;
    }

    /**
     * 进阶实现：
     *   1) 按负载因子预估 HashMap 初始容量，避免 rehash；
     *   2) 使用 getOrDefault 把"取值/判空/默认值"合为一次.
     */
    @Override
    public int doSearchAdvanced(List<Integer> nums, int target) {
        int n = nums.size();
        if (n == 0) return -1;

        // initialCapacity 选得稍大，避免插入过程中触发扩容
        Map<Integer, Integer> indexMap = new HashMap<>((int) (n / 0.75f) + 1);
        for (int i = 0; i < n; i++) {
            if (!indexMap.containsKey(nums.get(i))) {
                indexMap.put(nums.get(i), i);
            }
        }

        return indexMap.getOrDefault(target, -1);
    }
}
