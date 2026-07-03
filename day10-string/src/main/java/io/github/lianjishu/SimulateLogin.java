package io.github.lianjishu;
import java.util.Scanner;
public class SimulateLogin {
    static Scanner sc = new Scanner(System.in);
    private static String uname = "itheima";
    private static String pword = "123456";

    public static void main(String[] args) {
        int count = 1;
        while(count <=3){
            System.out.println("请输入用户名");
            String input_uname = sc.next();
            System.out.println("请输入密码");
            String input_pword = sc.next();
            if(input_uname.equals(uname) && input_pword.equals(pword)) {
                System.out.println("登录成功! ");
                break;
            }else{
                System.out.println("用户名或密码错误❌! ");
            }
            count ++;
        }
    }
}
