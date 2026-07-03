package io.github.lianjishu;
import java.util.Scanner;
public class RomanNumber {
    /* 键盘录入一个字符串，
    要求1：长度为小于等于9
    要求2：只能是数字

    将内容变成罗马数字

    下面是阿拉伯数字跟罗马数字的对比关系：
    I - 1、II - 2、III - 3、IV - 4、V - 5、VI - 6、VII - 7、VIII - 8、 IX - 9
    注意点：
    罗马数字里面是没有θ的
    如果键盘录入的数字包含θ，可以变成""（长度为θ的字符串）*/

    static private String[] map_table = {"", "I", "II", "III", "IV",
        "V", "VI", "VII", "VIII", "IX"};
    static Scanner sc = new Scanner(System.in);

    static String toRomanNum(String inputStr) {

        if(inputStr.length() > 9) {
            System.out.println("长度不能超过9");
            return "";
        }
        StringBuilder sBlder = new StringBuilder();
        for(int i=0; i<inputStr.length(); ++i) {
            sBlder.append(map_table[(inputStr.charAt(i)-'0')]);
        }
        return sBlder.toString();
    }

    public static void main(String[] args) {
        System.out.println("请输入一组数字(长度不超过9)");
        String str = sc.next();
        String res = toRomanNum(str);
        System.out.println(res);
    }
}
