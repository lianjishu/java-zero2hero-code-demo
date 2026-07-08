package io.github.lianjishu.Algo.Sort;

import java.util.List;

public class SelectionSort implements SortStrategy {

    @Override
    public void doSort(List<Integer> nums) {
        int n = nums.size();
        //外循环: 未排序区间为[i, n-1]
        for (int i = 0; i < n - 1; ++i) {
            int minInd = i;
            //内循环: 在未排序区间中找最小值
            for (int j = i; j < n - 1; ++j) {
                if (nums.get(j) < nums.get(minInd))
                    minInd = j;
            }
            // swap(nums[minInd], nums[i]);
            int temp = nums.get(minInd);
            nums.set(minInd, nums.get(i));
            nums.set(i, temp);
        }
    }
}
