package io.github.lianjishu.FiveExercises.RabbitProblem;

/**
 * 不死神兔问题（斐波那契兔子数列）
 * <p>
 * 有一对兔子，从出生后第三个月起每个月都生一对兔子，
 * 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，
 * 求第十二个月的兔子对数。
 * </p>
 */
public class RabbitProblem {
    /**
     * 
     * @param index 1, 2, 3, ...
     * @return 斐波那契数列: 1, 1, 2, 3, 5, ...
     */
    private static int getFibonacci(int index) {
        if (index == 1 || index == 2)
            return 1;

        return getFibonacci(index - 1) + getFibonacci(index - 2);
    }

    public static int solution(int index) {
        return getFibonacci(index);
    }

    public static void main(String[] args) {
        System.out.printf("答: 第十二个月的兔子对数为: %d%n", solution(12));
    }

}
