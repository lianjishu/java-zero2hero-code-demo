package io.github.lianjishu.Algo.Search;

import java.util.ArrayList;
import java.util.List;

/**
 * 分块查找（Block Search / Indexed Sequential Search）.
 *
 * 思路：
 *   1. 以 sqrt(n) 为块长，把数组分成若干块，每块记录 (max, begin, end)；
 *   2. 在"块的 max"组成的索引表上定位目标所在块；
 *   3. 在该块内顺序查找目标元素.
 * 适用于"块间有序、块内可无序"的场景；当数据全部有序时退化为一种有序查找.
 */
public class BlockSearch implements SearchStrategy {

    /** 索引项：块内最大值、起始下标、结束下标（含） */
    private record Block(int max, int beginIdx, int endIdx) {
    }

    @Override
    public String name() {
        return "BlockSearch";
    }

    /**
     * 基础实现：索引表采用顺序扫描定位目标块.
     */
    @Override
    public int doSearch(List<Integer> nums, int target) {
        int n = nums.size();
        if (n == 0) return -1;

        // 1. 构建索引表
        List<Block> blocks = buildBlocks(nums);

        // 2. 在索引表上顺序扫描：找第一个 max >= target 的块
        int blockIdx = -1;
        for (int i = 0; i < blocks.size(); i++) {
            if (target <= blocks.get(i).max()) {
                blockIdx = i;
                break;
            }
        }
        if (blockIdx == -1) return -1;

        // 3. 在目标块内顺序查找
        Block block = blocks.get(blockIdx);
        for (int i = block.beginIdx(); i <= block.endIdx(); i++) {
            if (nums.get(i).equals(target)) return i;
        }
        return -1;
    }

    /**
     * 进阶实现：索引表上采用二分查找，将定位成本从 O(k) 降到 O(log k).
     * 因为块的 max 单调不减，可以在索引表上直接二分.
     */
    @Override
    public int doSearchAdvanced(List<Integer> nums, int target) {
        int n = nums.size();
        if (n == 0) return -1;

        List<Block> blocks = buildBlocks(nums);

        // 二分查找第一个 max >= target 的块
        int lo = 0;
        int hi = blocks.size() - 1;
        int blockIdx = -1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (blocks.get(mid).max() >= target) {
                blockIdx = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        if (blockIdx == -1) return -1;

        Block block = blocks.get(blockIdx);
        for (int i = block.beginIdx(); i <= block.endIdx(); i++) {
            if (nums.get(i).equals(target)) return i;
        }
        return -1;
    }

    /**
     * 以 sqrt(n) 为块长构建索引表.
     * 块内最大值用于在索引表上做定位（要求块间按 max 单调不减）.
     */
    private List<Block> buildBlocks(List<Integer> nums) {
        int n = nums.size();
        // 块长取 sqrt(n)；最小为 1，避免 n=0 或 n=1 时退化为 0
        int blockSize = (int) Math.sqrt(n);
        if (blockSize == 0) blockSize = 1;

        List<Block> blocks = new ArrayList<>();
        int begin = 0;
        while (begin < n) {
            int end = Math.min(begin + blockSize - 1, n - 1);
            int max = nums.get(begin);
            for (int i = begin + 1; i <= end; i++) {
                if (nums.get(i) > max) max = nums.get(i);
            }
            blocks.add(new Block(max, begin, end));
            begin = end + 1;
        }
        return blocks;
    }
}
