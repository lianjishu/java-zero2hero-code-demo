package io.github.lianjishu.FiveExercises.MonkeyPeachProblem;

/**
 * <h3>猴子吃桃子问题（逆向递推 / 递归应用）</h3>
 * <p>
 * 有一堆桃子，猴子第一天吃了其中的一半，并多吃了一个！
 * 以后每天猴子都吃当前剩下来的一半，然后再多吃一个，
 * 第10天的时候（还没吃），发现只剩下一个桃子了，
 * 求最初总共多少个桃子？
 * </p>
 */
public class MonkeyPeachProblem {
    // 设P=X(i)为第i天有P个桃子(还没吃)
    // X(i+1) = X(i)*0.5-1
    // X(i) = 2*(X(i+1)+1)
    // X(10) = 1
    // X(9) = 2*(1+1) = 4
    // X(8) = 2*(4+1) = 10
    // X(7) = 2*(10+1) = 22
    // X(6) = 2*(22+1) = 46
    // X(5) = 2*(46+1) = 94
    // X(4) = 2*(94+1) = 190
    // X(3) = 2*(190+1) = 382
    // ...

    /**
     * 递推公式求值: X(i) = 2*(X(i+1)+1)
     *
     * @param nextValue X(i+1)
     * @return lastValue X(i)
     */
    private static int valueOfRecurrence(int nextValue) {
        return 2 * (nextValue + 1);
    }

    private static int recursion(int day) {
        // recur: 1->2->3->...->10 |10:1| -> 9✅ -> 8✅ ->... -> 1✅;
        if (day == 10) {
            System.out.printf("day=%d  num=%d%n",
                day, 1);
            return 1;
        }
            
        // return valueOfRecurrence(recursion(day + 1));
        int res = valueOfRecurrence(recursion(day + 1));
        System.out.printf("day=%d  num=%d%n",
                day, res);
        return res;
    }

    public static int solution() {
        return recursion(1);
    }

    public static void main(String[] args) {
        System.out.printf("答:第一天有%d个桃子%n", MonkeyPeachProblem.solution());
    }
}
