package io.github.lianjishu.set.tasteTreeSet;

import java.util.TreeSet;

public class TasteTreeSet {
/**
 * 利用TreeSet存储整数并且进行排序
 */
public class ExerciseD {
    public static void main(String[] args) {
        // 创建TreeSet对象
        TreeSet<Integer> nums = new TreeSet<>();
        // 添加元素6, 1, 2, 7, 9, 3, 4, 5, 10, 8
        nums.add(6);
        nums.add(1);
        nums.add(2);
        nums.add(7);
        nums.add(9);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(10);
        nums.add(8);
        System.out.println("auto sorted: " + nums);
    }
}
