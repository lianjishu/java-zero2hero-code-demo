package io.github.lianjishu.Day02_BasicConcept;
import java.util.Scanner; //导包
public class KeyboardInput {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        while(true){
            System.out.println("请输入一个数字(输入0可退出): ");
            int i = scn.nextInt();
            if(i == 0) break;
            System.out.println(i + "的平方是: " + i*i);
        }
    }
}

