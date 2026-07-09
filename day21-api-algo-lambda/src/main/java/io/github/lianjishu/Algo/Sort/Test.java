package io.github.lianjishu.Algo.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.github.lianjishu.Algo.Sort.SortStrategy.SortNames;

public class Test {
    public static void main(String[] args) {
        SortStrategy bubbleSort = StrategyFactory.create(SortNames.BUBBLE_SORT);
        List<Integer> nums = new ArrayList<>(Arrays.asList(
                6, 1, 2, 7, 9, 3, 4, 5, 10, 8));
        SortStrategy.printer(nums);
        long begin = System.nanoTime();
        bubbleSort.doSort(nums);
        long end = System.nanoTime();
        SortStrategy.printer(nums);
        System.out.println("" + begin);
        System.out.println("" + end);
        System.out.printf("耗时: %d ns%n", end - begin);

        System.out.println("----------------------------------------");

        SortStrategy selectionSort = StrategyFactory.create(SortNames.SELECTION_SORT);
        nums = new ArrayList<>(Arrays.asList(
                6, 1, 2, 7, 9, 3, 4, 5, 10, 8));
        SortStrategy.printer(nums);
        begin = System.nanoTime();
        selectionSort.doSort(nums);
        end = System.nanoTime();
        SortStrategy.printer(nums);
        System.out.printf("耗时: %d ns%n", end - begin);

        System.out.println("----------------------------------------");

        SortStrategy insertionSort = StrategyFactory.create(SortNames.INSERTION_SORT);
        nums = new ArrayList<>(Arrays.asList(
                6, 1, 2, 7, 9, 3, 4, 5, 10, 8));
        SortStrategy.printer(nums);
        begin = System.nanoTime();
        insertionSort.doSort(nums);
        end = System.nanoTime();
        SortStrategy.printer(nums);
        System.out.printf("耗时: %d ns%n", end - begin);

        System.out.println("----------------------------------------");

        nums = new ArrayList<>(Arrays.asList(
                6, 1, 2, 7, 9, 3, 4, 5, 10, 8));
        SortStrategy.printer(nums);
        begin = System.nanoTime();
        insertionSort.doSortAdvanced(nums);
        end = System.nanoTime();
        SortStrategy.printer(nums);
        System.out.printf("耗时: %d ns%n", end - begin);

        System.out.println("----------------------------------------");

        SortStrategy quickSort = StrategyFactory.create(SortNames.QUICK_SORT);
        nums = new ArrayList<>(Arrays.asList(
                6, 1, 2, 7, 9, 3, 4, 5, 10, 8));
        SortStrategy.printer(nums);
        begin = System.nanoTime();
        quickSort.doSort(nums);
        end = System.nanoTime();
        SortStrategy.printer(nums);
        System.out.printf("耗时: %d ns%n", end - begin);
    }
}
