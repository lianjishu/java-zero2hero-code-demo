package io.github.lianjishu.Algo.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.github.lianjishu.Algo.Sort.SortStrategy.SortNames;

public class Test {
    public static void main(String[] args) {
        SortStrategy bubbleSort = StrategyFactory.create(SortNames.BUBBLE_SORT);
        List<Integer> nums = new ArrayList<>(Arrays.asList(
                3, 5, 2, 1, 4));
        SortStrategy.printer(nums);
        bubbleSort.doSort(nums);
        SortStrategy.printer(nums);

        System.out.println("--------------------");

        SortStrategy selectionSort = StrategyFactory.create(SortNames.SELECTION_SORT);
        nums = new ArrayList<>(Arrays.asList(
                3, 5, 2, 1, 4));
        SortStrategy.printer(nums);
        selectionSort.doSort(nums);
        SortStrategy.printer(nums);

        System.out.println("--------------------");

        SortStrategy insertionSort = StrategyFactory.create(SortNames.INSERTION_SORT);
        nums = new ArrayList<>(Arrays.asList(
                3, 5, 2, 1, 4));
        SortStrategy.printer(nums);
        insertionSort.doSort(nums);
        SortStrategy.printer(nums);

        System.out.println("--------------------");

        nums = new ArrayList<>(Arrays.asList(
                3, 5, 2, 1, 4));
        SortStrategy.printer(nums);
        insertionSort.doSortAdvanced(nums);
        SortStrategy.printer(nums);

        System.out.println("--------------------");

        SortStrategy quickSort = StrategyFactory.create(SortNames.QUICK_SORT);
//		nums = new ArrayList<>(Arrays.asList(
//				6, 1, 2, 7, 9, 3, 4, 5, 10, 8));
        nums = new ArrayList<>(Arrays.asList(
                3, 1, 2, 5, 4));
        SortStrategy.printer(nums);
        quickSort.doSort(nums);
        SortStrategy.printer(nums);
    }
}
