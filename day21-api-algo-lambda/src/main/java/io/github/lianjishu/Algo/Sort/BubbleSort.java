package io.github.lianjishu.Algo.Sort;

import java.util.List;

public class BubbleSort implements SortStrategy {
    @Override
    public void doSort(List<Integer> nums) {
        int n = nums.size();
        for (int j = 0; j < n - 1; ++j) {
            for (int i = 0; i < n - j - 1; ++i) {
                if (nums.get(i) > nums.get(i + 1)) {
                    int temp = nums.get(i);
                    nums.set(i, nums.get(i + 1));
                    nums.set(i + 1, temp);
                }
            }
        }
    }

//    public void printer(List<Integer> nums) {
//        System.out.print("[ ");
//        for (int elem : nums) {
//            System.out.printf("%d ", elem);
//        }
//        System.out.print("]");
//        System.out.println();
//
//    }
}
