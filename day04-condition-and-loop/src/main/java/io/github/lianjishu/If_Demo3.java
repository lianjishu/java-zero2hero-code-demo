package io.github.lianjishu;
import java.util.Scanner;
public class If_Demo3 {
    /*
        在实际开发中，多种情况判断时，会用到if的第三种格式：
        需求：
        商场都会有VIP的会员制，根据不同的会员会有不同的折扣。
        假设商品总价为1000。
        键盘录入会员级别，并计算出实际支付的钱。
        会员1级：打9折。
        会员2级：打8折。
        会员3级：打7折。
        非会员：不打折，要打也是打骨折。
    */
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int price = 1000;
        double pay = 1000;
        System.out.println("你是会员吗? Y/n");
        String yesOno = sc.next();
        if(yesOno.equals("N") || yesOno.equals("n")){
            System.out.println("实际应付: " + price + "元");
            return;
        }else if(yesOno.equals("Y") || yesOno.equals("y")){
            System.out.println("请输入会员级别: ");
            int level = sc.nextInt();
            if(level == 1)
                pay = price * 0.9;
            else if(level == 2)
                pay = price * 0.8;
            else if (level == 3)
                pay = price * 0.7;
            else {
                System.out.println("你的输入有误! ");
                return;
            }
            System.out.println("实际应付: " + pay + "元");
        }
    }

}
