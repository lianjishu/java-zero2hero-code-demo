
public class IsPrime {
    /*
     * 算法小题(质数)
     * 需求：
     * 判断一个数是否为一个质数
     */
    private boolean isPrime(int num) {
        for (int i = 2; i < num; ++i) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public void solution(int num) {
        var res = isPrime(num);
        if (res)
            System.out.println(" " + num + "是一个质数");
        else
            System.out.println(" " + num + "不是一个质数");
    }
}