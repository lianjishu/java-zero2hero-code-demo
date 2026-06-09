package io.github.lianjishu.Day03_Operator;
import java.util.Scanner;
public class TernaryOperator {
    // 案例一:
    static void example1() {
        // 定义一个变量记录两个整数的较大值并输出
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入两个整数: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        scanner.close();
        int max = num1>num2 ? num1 : num2;
        System.out.println(num1 + ", " + num2 + " 较大值为: " + max);
    }

    // 案例二:
    static void example2() {
        //一座寺庙里住着三个和尚, 一只他们的身高分别为 150cm, 210cm, 165cm.
        int height1 = 150, height2 = 210, height3 = 165;
        int temp = height1>height2 ? height1 : height2;
        int max = temp>height3 ? temp : height3;
        System.out.println("最大值为: " + max);
    }
    public static void main(String[] args) {
        example1();
        System.out.println("----------------------------------");
        example2();
    }
}
