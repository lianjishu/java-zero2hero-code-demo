package io.github.lianjishu.Algo.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort implements SortStrategy {

    @Override
    public void doSort(List<Integer> nums) {
//        6, 1, 2, 7, 9, 3, 4, 5, 10, 8

//      [Loop1] start=0 end=9 base=6
//        (3, 1, 2, 5, 4), 6, (9, 7, 10, 8)
//      [Loop2] start=0 end=4 base=3
//        (2, 1, 3, 5, 4), 6, (9, 7, 10, 8)

//      [Loop3] start=6 end=9 base=9
//        (2, 1), 3, (5, 4), 6, (8, 7), 9, (10)
//      [Loop4] start=0 end=1 base=2
//        (1, 2), 3, (5, 4), 6, (8, 7), 9, (10)
//      [Loop5] start=3 end=4 base=5
//        (1, 2), 3, (4, 5), 6, (8, 7), 9, (10)
//      [Loop6] start=6 end=7 base=8
//        (1, 2), 3, (4, 5), 6, (7, 8), 9, (10)
//      END...
        quickSortCallback(nums, 0, nums.size() - 1);

    }

    private static void doLoop01() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(6, 1, 2, 7, 9, 3, 4, 5, 10, 8));
        // 6, 1, 2, 7, 9, 3, 4, 5, 10, 8   || Base: 6
        // L ------------------------- R

        // 6, 1, 2, 7, 9, 3, 4, 5, 10, 8  || R: 5
        // L--------------------R

        // 6, 1, 2, 7, 9, 3, 4, 5, 10, 8  || L: 7
        // ---------L-----------R

        // 6, 1, 2, 5, 9, 3, 4, 7, 10, 8  || L<->R
        // ---------L-----------R

        // 6, 1, 2, 5, 9, 3, 4, 7, 10, 8  || L++ R--
        // ------------L-----R---

        // 6, 1, 2, 7, 9, 3, 4, 5, 10, 8

        // 6, 1, 2, 5, 4, 3, 9, 7, 10, 8
        int n = nums.size();
        SortStrategy.printer(nums);
//        System.out.println("----------------------------------------------------");
        // for (int i = 0; i < n-1; ++i) {
        int i = 0;
        int base = nums.get(i);

        int left = i + 1; // 左指针: 向右寻找比base大的数
        int right = n - 1; // 右指针: 向左寻找比base小的数
        int count = 0;
        System.out.printf("n=%d  base=%d\n", n, base);
        System.out.println("----------------------------------------------------");

        while (left < right) {//fix: while(left < right)
            count++;
            System.out.printf("[count%d]%nleft=%d  right=%d%n", count, left, right);
            // 先动right
            System.out.println("--- 右指针: 向左寻找比base小的数 ---");
            while (left < right && nums.get(right) >= base) {
                System.out.printf("`left:%d<right%d && nums[right]:%d >= base:%d` => %b%n", left, right, right, base, left < right && nums.get(right) >= base);
                right--;
                System.out.println("right--: right=" + right);

            }
            System.out.println("--------------------------------");
            // 再动left
            System.out.println("----左指针: 向右寻找比base大的数----");
            while (left < right && nums.get(left) <= base) {
                System.out.printf("`left:%d<right%d && nums[left]:%d <= base:%d` => %b%n", left, right, left, base, left < right && nums.get(left) <= base);
                left++;
                System.out.println("left++: left=" + left);


            }
            System.out.println("--------------------------------");

            // swap(nums[left],nums[right])
            System.out.printf("swap(nums[%d], nums[%d])%n", left, right);
            int temp = nums.get(left);
            nums.set(left, nums.get(right));
            nums.set(right, temp);
            SortStrategy.printer(nums);

            right--;
            left++;
            System.out.printf("right--, left++ => left=%d right=%d%n", left, right);
            System.out.println("----------------------------------------------------");
        }
        SortStrategy.printer(nums);
        System.out.println("left=" + left + "  " + "right=" + right);
        System.out.printf("swap(nums[%d],nums[%d])%n", left, i);
        int temp = nums.get(left);
        nums.set(left, nums.get(i));
        nums.set(i, temp);
        SortStrategy.printer(nums);
        // }
    }

    private static void testDoSort() {
//        quickSortCallback
    }

    /**
     * @param nums  待排序数组
     * @param start 要查找的范围起始索引
     * @param end   要查找的范围终点索引
     */
    private static void quickSortCallback(List<Integer> nums, int start, int end) {
//        SortStrategy.printer(nums);
        int i = start;
        int j = end;
        if (i > j) return;
        int base = nums.get(i);

        while (i < j) {
            //移动右指针j寻找第一个小于base的数
            while (i < j && nums.get(j) >= base) j--;
            //移动左指针i寻找第一个大于base的数
            while (i < j && nums.get(i) <= base) i++;
            //交换nums[i],nums[j]
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
        // [3 1 2 5 4]

        // [3   1   2   5   4]
        //         i-j

        // 此时i=j, 基准数归位
        int temp = nums.get(i);
        nums.set(i, base);
        nums.set(start, temp);

        quickSortCallback(nums, start, i - 1);
        quickSortCallback(nums, i + 1, end);

    }
}
