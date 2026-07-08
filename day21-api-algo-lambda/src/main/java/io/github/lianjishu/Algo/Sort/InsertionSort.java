package io.github.lianjishu.Algo.Sort;

import java.util.List;

public class InsertionSort implements SortStrategy {

    @Override
    public void doSort(List<Integer> nums) {
        int n = nums.size();

        //寻找已排序区间 : [0, left]
        int left = 0, right = 1;
        while (nums.get(left) <= nums.get(right)) {
            left++;
            right++;
        }
        //处理未排序区间: [right, n-1]

        for (int i = right; i < n; ++i) {
            int j = i;
            while (j > 0 && nums.get(j - 1) > nums.get(j)) {
                int tmp = nums.get(j);
                nums.set(j, nums.get(j - 1));
                nums.set(j - 1, tmp);
                j--;
            }

        }
    }

    @Override
    public void doSortAdvanced(List<Integer> nums) {
        //默认已处理区间是 [0, i] || i=0,1,...,n-1
        int n = nums.size();
        for (int i = 0; i < n - 1; i++) {
            int j = i + 1;
            int base = nums.get(j);
            while (j > 0 && nums.get(j - 1) > base) { //已排序区间中比base大的往后移一下
                nums.set(j, nums.get(j - 1));
                j--;
            }
            nums.set(j , base);
        }
    }
}



