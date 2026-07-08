package io.github.lianjishu.Algo.Sort;

import io.github.lianjishu.Algo.Sort.SortStrategy.SortNames;

public final class StrategyFactory {
    private StrategyFactory() {
    }

    /**
     * @param name BUBBLE_SORT / INSERTION_SORT / QUICK_SORT /
     *             SELECTION_SORT
     * @return 策略实例
     * @throws IllegalArgumentException 未知名
     */
    public static SortStrategy create(SortNames name) {
        return switch (name) {
            case SortStrategy.SortNames.BUBBLE_SORT -> new BubbleSort();
            case SortStrategy.SortNames.INSERTION_SORT -> new InsertionSort();
            case SortStrategy.SortNames.QUICK_SORT -> new QuickSort();
            case SortStrategy.SortNames.SELECTION_SORT -> new SelectionSort();
            default -> {
                throw new IllegalArgumentException(
                        "Unknown sort strategy: " + name);
            }
        };
    }

}
