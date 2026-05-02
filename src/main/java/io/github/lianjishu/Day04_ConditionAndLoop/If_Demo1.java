package io.github.lianjishu.Day04_ConditionAndLoop;
import java.util.Scanner;
public class If_Demo1 {
    /* if的第一种格式 */
    // 案例:
    //键盘录入女婿酒量(单位为斤),如果大于2斤,老丈人给出回应, 反之不回应.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wine = scanner.nextInt();
        if(wine > 2){
            System.out.println("小伙子,不错哟! ");
//        }else{
//            System.out.println("  ");
        }
    }
}
