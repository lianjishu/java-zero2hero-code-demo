package io.github.lianjishu;
import java.util.Scanner;

public class Practice {
    static Scanner scanner = new Scanner(System.in);
    //问题一: 去哪吃
    static void problem_01() {
        /*
        假设,用户在超市实际购买的商品总价格为600元
        键盘录入一个整数表示用户实际支付的钱
        如果付款大于等于600, 表示付款成功,否则付款失败.
        */
        int price = scanner.nextInt();
        if(price >= 600)
            System.out.println("付款成功!");
        else
            System.out.println("付款失败!");
    }
    // 问题二: 影院选座
    static void problem_02() {
        /*
        * 假设某影院售卖了100张票, 票号简化为1~100.
        * 其中奇数票号的座左侧, 偶数票号坐右侧.
        * 键盘录入一个整数表示票号,
        * 根据情况不同, 给出不同的提示:
        * 奇数票号, 输出坐左边
        * 偶数票号, 输出坐右边
        */
        int id = scanner.nextInt();
        if(id<1 || id>100) {
            System.out.println("无效票号!");
            return;
        }
        if(id%2 == 0){
            System.out.println("坐右边");
        }else{
            System.out.println("坐左边");
        }
    }

    public static void main(String[] args) {
       problem_01();
       problem_02();
    }
}
