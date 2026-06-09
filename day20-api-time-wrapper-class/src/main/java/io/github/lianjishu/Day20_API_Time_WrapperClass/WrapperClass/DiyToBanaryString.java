package io.github.lianjishu.Day20_API_Time_WrapperClass.WrapperClass;


public class DiyToBanaryString {
    /**
     * 原数不断除以二, 拿到每一步的余数, 直到原数为0
     * 余数倒着拼接
     */

    public static String toBinaryString(int num) {
        StringBuilder ans = new StringBuilder();
        while(num != 0) {
            int remainder = num % 2;
            ans.insert(0, remainder);
            num /= 2;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(io.github.lianjishu.
                Day20_API_Time_WrapperClass.
                WrapperClass.
                DiyToBanaryString.
                toBinaryString(2));
    }
}
