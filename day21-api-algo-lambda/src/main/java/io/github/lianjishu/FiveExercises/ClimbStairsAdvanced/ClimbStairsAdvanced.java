package io.github.lianjishu.FiveExercises.ClimbStairsAdvanced;

import java.util.Arrays;

/**
 * 爬楼梯问题（斐波那契数列应用）
 * <p>
 * 可爱的小明特别喜欢爬楼梯，
 * 他有的时候一次爬一个台阶，
 * 有的时候一次爬两个台阶,
 * 还有的时候一次爬三个台阶!!!
 * 如果这个楼梯有20个台阶，小明一共有多少种爬法呢？
 * </p>
 */

class ClimbStairsAdvanced {
    private static int climbStairs(int n, int[] memo) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        if (memo[n] != 0)return memo[n];

        memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo) + climbStairs(n - 3, memo);
        
        return memo[n];
    }

    public static void main(String[] args) {
        int[] memo = new int[21];
        System.out.println("------------------------------");
        long start2 = System.nanoTime();
        System.out.printf("答: 这个楼梯有20个台阶，小明一共有%d种爬法%n", climbStairs(20, memo));
        long end2 = System.nanoTime();
        System.out.println("memo = " + Arrays.toString(memo));
        System.out.println("Timed: " + (end2 - start2) + " ns");
        System.out.println("------------------------------");
    }
}
