package io.github.lianjishu.Algo.Sort;

import java.util.List;

public interface SortStrategy {
    public enum SortNames {
        BUBBLE_SORT("BUBBLE_SORT"), INSERTION_SORT("INSERTION_SORT"), QUICK_SORT("QUICK_SORT"),
        SELECTION_SORT("SELECTION_SORT");

        public final String name;

        private SortNames(String name) {
            this.name = name;
        }
    }

    void doSort(List<Integer> nums);

    default void doSortAdvanced(List<Integer> nums) {
    }

    static void printer(List<Integer> nums) {
        System.out.print("[ ");
        for (int elem : nums) {
            System.out.printf("%d ", elem);
        }
        System.out.print("]");
        System.out.println();

    }
}
