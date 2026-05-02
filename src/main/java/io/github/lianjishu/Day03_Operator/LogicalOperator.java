package io.github.lianjishu.Day03_Operator;
import java.util.Scanner;
public class LogicalOperator {
    public static void solution(int num1, int num2){
//        if (num1==6 || num2==6 || (num1+num2)%6 == 0)
//            System.out.println(true);
//        else
//            System.out.println(false);
        System.out.println(num1 == 6 || num2 == 6 || (num1 + num2) % 6 == 0);
    }

    public static void main(String[] args) {
        /*
            逻辑运算符: & | !
            短路逻辑运算符 && ||
        */
        /*小练习*/
        //数字6是一个伟大的数字,键盘录入两个整数
        //如果其中一个为6, 最终结果输出true
        //如果两数这和为6的倍数,最终结果输出true
        //其他情况均输出false
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入第一个整数: ");
        int num1 = scanner.nextInt();
        System.out.println("输入第二个整数: ");
        int num2 = scanner.nextInt();

        solution(num1, num2);
    }
}
