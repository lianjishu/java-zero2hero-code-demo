package implement3;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer> {
    public static int findNextPrime(int n) {
        if (n < 2) return 2;

        int candidate = n;
        // If n is even, start from next odd number
        if (candidate % 2 == 0) candidate++;
        else candidate += 2;

        while (!isPrime(candidate)) {
            candidate += 2; // Skip even numbers
        }
        return candidate;
    }

    /**
     * 判断是否为质数 (所有大于3的质数都可以表示为 6k ± 1)
     */
    private static boolean isPrime(int num) {
        if(num < 2) return false; //质数要求大于1 (1本身既不是质数也不是合数)
        if(num==2 || num==3) return true; //2和3本身都是质数
        if(num%2==0 || num%3==0) return false; //排除所有大于3的2的倍数和3的倍数

        // 所有大于3的质数都可以表示为 6k ± 1
        for (int i = 5; i <= Math.sqrt(num); i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public Integer call() {return 1;}

    public Integer call(int i) {
        return findNextPrime(100);
    }
}

