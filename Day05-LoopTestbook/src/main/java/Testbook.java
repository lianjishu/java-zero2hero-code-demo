import javax.swing.text.StyledEditorKit;
import java.util.Random;
import java.util.Scanner;

public class Testbook {
    static Random rand = new Random();
    static Scanner sc = new Scanner(System.in);

    static void test_01() {
        /**
        案例1：逢7过
        朋友聚会的时候可能会玩一个游戏：逢7过
        游戏规则：从任意一个数字开始报数，当你要报的数字是包含7或者是7的倍数时都要说过：过
        需求：使用程序在控制台打印出1-100之间的满足逢七必过规则的数据  **/
        int start = rand.nextInt(100) + 1;
        for(int i=start; i<=100; ++i){
            int num = i;
            if(num % 7 == 0){
                System.out.println("过!");
                continue;
            }else {
                int digit = 0;
                while (num != 0) {
                    digit = num % 10;
                    num /= 10;
                    if (digit == 7) {
                        System.out.println("过!");
                        break;
                    }else{
                        System.out.println(i);
                        break;
                    }
                }
            }

        }
    }

    /*
    * 案例2: 判断质数
    *
    * */
    static void test_02() {
        System.out.println("要判断质数,请先输入一个整数: ");
        int num = sc.nextInt();
        boolean is_prime = true;
        for(int i=2; i<num; ++i) {
            if(num % i == 0) {
                is_prime = false;
                break;
            }
        }
        System.out.println(is_prime ? "YES" : "NO");
    }

    public static void main(String[] args) {
//        test_01();
        test_02();
    }
}
