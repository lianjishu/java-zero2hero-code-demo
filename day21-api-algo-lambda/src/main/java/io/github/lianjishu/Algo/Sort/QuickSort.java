package io.github.lianjishu.Algo.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort implements SortStrategy {

    @Override
    public void doSort(List<Integer> nums) {
        int n = nums.size();
        for (int i = 0; i < n - 1; ++i) {
            int base = nums.get(i);
            int left = i + 1; // 左指针 : 向右寻找比base大的数
            int right = n - 1; // 右指针 : 向左寻找比base小的数
            while (left < right) {
                // 先动right
                while (left < right && nums.get(right) >= base) {
                    right--;
                }
                // 再动left
                while (left < right && nums.get(left) <= base) {
                    left++;
                }
                // swap(nums[left],nums[right])
                int temp = nums.get(left);
                nums.set(left, nums.get(right));
                nums.set(right, temp);

                right--;
                left++;
            }
            int temp = nums.get(left);
            nums.set(left, nums.get(right));
            nums.set(right, temp);
        }
    }

    public static void main(String[] args) {
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
}
