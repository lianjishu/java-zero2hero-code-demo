import  java.util.Scanner;
/**
 * 练习一：飞机票
 * 需求:
   机票价格按照淡季旺季、头等舱和经济舱收费、输入机票原价、月份和头等舱或经济舱。
   按照如下规则计算机票价格：旺季（5-10月）头等舱9折，经济舱8.5折，淡季（11月到来年4月）头等舱7折，经济舱6.5折
 * */
public class PlaneTicket {
    static Scanner sc = new Scanner(System.in);
    //辅助函数 | 检查是淡季0还是旺季1
    static int checkSeason(int month) {
        if(5<=month && month<=10)
            return 1;
        else if(11<=month&&month<=12 || 1<=month&&month<=4)
            return 0;
        return -1;
    }
    //辅助函数 | 给出折扣
    static double getDiscount(int month, int seat_t) {
        int off_peak = checkSeason(month);
        if(off_peak == 0) {
            if(seat_t == 0)
                return 6.5;
            else if(seat_t == 1)
                return 7.0;
        }else {
            if (seat_t == 0)
                return 8.5;
            else if (seat_t == 1)
                return 9.0;
        }
        return -1;
    }
    //主逻辑
    public  static void main(String[] args) {
        //录入机票原价、月份和头等舱或经济舱
        System.out.println("请输入机票原价: ");
        int price = sc.nextInt();
        System.out.println("请输入月份: ");
        int month = sc.nextInt();
        System.out.println("请输入购买的舱位: 0|经济舱 1|头等舱");
        int seat_t = sc.nextInt();
        //数据处理
        double discount = getDiscount(month, seat_t);
        double final_price = discount*0.1*price;
        System.out.println("最终票价为: "+final_price);
    }
}
