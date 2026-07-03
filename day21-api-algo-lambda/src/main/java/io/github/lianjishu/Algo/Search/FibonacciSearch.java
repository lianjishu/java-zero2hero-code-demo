  package io.github.lianjishu.Algo.Search;

import java.util.ArrayList;
import java.util.List;

/**
 * 斐波那契查找（Fibonacci Search）.
 *
 * 在有序数组上按斐波那契数列进行分割，时间复杂度 O(log n).
 * 与二分查找相比，分割点的计算只用加减法（low + F[k-1] - 1），
 * 避免了除法运算，理论上更省时.
 * 注意：要求数组已按升序排列.
 */
public class FibonacciSearch implements SearchStrategy {

    @Override
    public String name() {
        return "FibonacciSearch";
    }

    /**
     * 标准斐波那契查找.
     * 1. 构造斐波那契数列 F[0]=0, F[1]=1, F[2]=1, F[3]=2, F[4]=3, F[5]=5 ...;
     * 2. 找到最小 k 使 F[k] >= n，并用末尾元素把数组补齐到 F[k] 个；
     * 3. 用 mid = low + F[k-1] - 1 不断缩小区间.
     */
    @Override
    public int doSearch(List<Integer> nums, int target) {
        int n = nums.size();
        if (n == 0) return -1;
        // 单元素情形：直接判等即可，避免 F[0] 越界
        if (n == 1) return nums.get(0).equals(target) ? 0 : -1;

        // 1. 构造斐波那契数列
        int[] F = new int[n + 5];
        F[0] = 0;
        F[1] = 1;
        for (int i = 2; i < F.length; i++) {
            F[i] = F[i - 1] + F[i - 2];
        }

        // 2. 找最小 k 使 F[k] >= n
        int k = 0;
        while (F[k] < n) k++;

        // 3. 用末尾元素把数组补齐到 F[k] 个，保证比较时不会越界
        List<Integer> arr = new ArrayList<>(nums);
        for (int i = n; i < F[k]; i++) {
            arr.add(nums.get(n - 1));
        }

        // 4. 主循环
        int low = 0;
        int high = n - 1;
        while (low <= high && k >= 2) {
            int mid = low + F[k - 1] - 1;
            if (mid >= arr.size()) mid = arr.size() - 1; // 防御

            int midVal = arr.get(mid);
            if (midVal == target) {
                // 若命中的是补齐位，则折回到真实右边界
                return Math.min(mid, n - 1);
            } else if (midVal < target) {
                low = mid + 1;
                k -= 2;          // 后段长度 F[k-2]
            } else {
                high = mid - 1;
                k -= 1;          // 前段长度 F[k-1]
            }
        }

        // 5. 收尾：当 k < 2 已无法再用斐波那契分割，对剩余区间做线性扫描
        for (int i = low; i <= high && i < n; i++) {
            if (arr.get(i).equals(target)) return i;
        }
        return -1;
    }

    /**
     * 进阶实现：进入主算法前先做上下界检查.
     * 升序数组中 target 小于最小值或大于最大值时一定不在，
     * 提前返回 -1 可省去构造斐波那契序列与补齐数组的开销.
     */
    @Override
    public int doSearchAdvanced(List<Integer> nums, int target) {
        int n = nums.size();
        if (n == 0) return -1;
        int first = nums.get(0);
        int last = nums.get(n - 1);
        if (target < first || target > last) return -1;
        return doSearch(nums, target);
    }
}
