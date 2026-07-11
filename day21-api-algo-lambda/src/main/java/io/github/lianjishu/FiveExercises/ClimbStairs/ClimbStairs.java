package io.github.lianjishu.FiveExercises.ClimbStairs;

import java.util.Arrays;

/**
 * 爬楼梯问题（斐波那契数列应用）
 * <p>
 * 可爱的小明特别喜欢爬楼梯，
 * 他有的时候一次爬一个台阶，
 * 有的时候一次爬两个台阶。
 * 如果这个楼梯有20个台阶，小明一共有多少种爬法呢？
 * </p>
 * 
 * <p>
 * <b>运算结果示例：</b>
 * </p>
 * <ul>
 * <li>1层台阶 → 1种爬法</li>
 * <li>2层台阶 → 2种爬法</li>
 * <li>7层台阶 → 21种爬法</li>
 * </ul>
 */

public class ClimbStairs {
   /**
    * 计算爬 n 层台阶的方法总数
    * <p>
    * 计算爬 n 层台阶的方法总数(每次 1 或 2 阶)。
    * 本质上就是 Fibonacci:f(n) = F(n+1),其中 F 是标准 Fib 数列。
    * </p>
    * 计算n层只需要用到n-1 n-2层,
    *
    * @param n 台阶总数（正整数）
    * @return 爬到第 n 层的爬法总数
    * @throws IllegalArgumentException 如果 n &lt;= 0，抛出非法参数异常
    *                                  计算第5层 会去算4, 3, 会去算3,2又去算2... 很多重复计算
    * 
    */
   private static int climbStairs(int n) {
      if (n < 1)
         throw new IllegalArgumentException();
      // 处理 n=1 和 n=2 的边界
      if (n == 1)
         return 1;
      if (n == 2)
         return 2;

      return climbStairs(n - 1) + climbStairs(n - 2);
   }

   // 算过的就存起来 空间换时间
   private static int climbStairsMemo(int n, int[] memo) {
      if (n < 1) throw new IllegalArgumentException();
      if (n == 1) return 1;
      if (n == 2) return 2;
      if (memo[n] != 0) return memo[n];

      memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);

      return memo[n];
   }

   public static void main(String[] args) {
      System.out.println("--------climbStairs----------");
      long start1 = System.nanoTime();
      System.out.printf("答: 这个楼梯有20个台阶，小明一共有%d种爬法%n", climbStairs(20));
      long end1 = System.nanoTime();
      System.out.println("Timed: " + (end1 - start1) + " ns");
      System.out.println("-----------------------------");
      System.out.println();

      int[] memo = new int[21];
      System.out.println("--------climbStairsMemo-------");
      long start2 = System.nanoTime();
      System.out.printf("答: 这个楼梯有20个台阶，小明一共有%d种爬法%n", climbStairsMemo(20, memo));
      long end2 = System.nanoTime();
      System.out.println("memo = " + Arrays.toString(memo));
      System.out.println("Timed: " + (end2 - start2) + " ns");
      System.out.println("------------------------------");
   }
}