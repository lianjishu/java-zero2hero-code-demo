package io.github.lianjishu;
import java.util.ArrayList;
import java.util.Random;
/**
 * 定义方法实现随机产生一个5位的验证码
 * 验证码格式：
    长度为5
    前四位是大写字母或者小写字母
    最后一位是数字
 */

public class VerificationCode {
    //用于生成随机数
    static Random random = new Random();
    //创建字母数字和数字数组
    static ArrayList<Character> letters = new ArrayList<>(52);
    static ArrayList<Character> nums = new ArrayList<>(10);
    //初始化字母数组
    static void initLetters() {
        for(int i=0; i<52; ++i) {
            if(i<=25) {
                letters.add((char)(97+i));
            }else {
                letters.add((char)(65+i-26));
            }
        }
    }
    //初始化数字数组
    static void initNums() {
        for(int i=0; i<10; ++i) {
            nums.add((char)(48+i));
        }
    }
    static void printer(ArrayList<Character> arrayList) {
        System.out.print("[");
        for(int i=0; i<arrayList.size(); ++i) {
            System.out.print(arrayList.get(i));
            if(i != arrayList.size()-1)
                System.out.print(", ");
        }
        System.out.println("]");
    }
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        initLetters();
        initNums();
        for(int times = 0; times<4; ++times) {
            var rIndex = random.nextInt(letters.size());
            result.append(letters.get(rIndex));
        }
        var rIndex = random.nextInt(nums.size());
        result.append(nums.get(rIndex));
        System.out.println(result);
    }
}
