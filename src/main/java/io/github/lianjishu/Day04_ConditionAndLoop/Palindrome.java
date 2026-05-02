package io.github.lianjishu.Day04_ConditionAndLoop;
import java.util.Scanner;
//import java.util.
public class Palindrome {
    // 回文数
    // 需求：给你一个整数x
    // 如果 x 是一个回文整数，打印 true，否则，返回 false。
    // 解释：回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
    // 例如，121 是回文，而 123 不是。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个整数: ");
        int i_num = sc.nextInt();
        String str_num = String.valueOf(i_num);
        boolean isPald = true;
        int len = str_num.length();
        for(int i=0; i<len; ++i){
            if(str_num.charAt(i) != str_num.charAt(len-1-i))
                isPald = false;
        }
        String res = (isPald ? "YES" : "NO");
        System.out.println(res);
    }
}
