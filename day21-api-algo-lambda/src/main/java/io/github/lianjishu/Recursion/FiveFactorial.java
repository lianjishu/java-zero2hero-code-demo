package io.github.lianjishu.Recursion;

public class FiveFactorial {

//    5! = 5 x 4 x 3 x 2 x 1
//       = 5 x (4!)
//       = 5 x 4 x (3!)
//       = 5 x 4 x 3 x (2!)
//       = 5 x (4 x 3 x 2 x (1!)
//       = 5 x (4 x 3 x 2 x 1 )

    private static int recur(int num) {
        if (num <= 1) return 1;

        return num * recur(num - 1);
    }

    /**
     * recur(5)
     *      return 5 * recur(4);//return 5*24
     *
     * recur(4)
     *      return 4 * recur(3);//return 4*6
     *
     * recur(3)
     *      return 3 * recur(2); //return 3*2
     *
     * recur(2)
     *      return 2 * recur(1); //return 2*1
     *
     * recur(1) => 1
     *      return 1;
     */

    public static int doFactorial(int n) {
        return recur(n);
    }

    public static void main(String[] args) {
        System.out.println(doFactorial(5));
    }
}
