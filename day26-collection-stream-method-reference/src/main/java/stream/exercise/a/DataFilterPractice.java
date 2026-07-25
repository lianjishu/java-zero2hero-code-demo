package stream.exercise.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * 练习
 * <p>
 * 数据过滤
 * <p>
 * 定义一个集合，并添加一些整数 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
 * <br>
 * 过滤奇数，只留下偶数。
 * <br>
 * 并将结果保存起来
 */
public class DataFilterPractice {
    static ArrayList<Integer> nums = new ArrayList<>();

    static {
        Collections.addAll(nums, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    private static ArrayList<Integer> getEven() {
        return nums.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static void main(String[] args) {
        System.out.println("evenList: " + getEven());
    }
}
