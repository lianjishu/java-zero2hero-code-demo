package io.github.lianjishu.Day02_BasicConcept;
public class VariableTest {
    //变量小练习
    private static int counting(){
    //公交车上一开始没有乘客
        int count = 0;
    //第一站: 上去一位乘客
        count += 1;
    //第二站: 上去两位乘客, 下来一位乘客
        count += 2;
        count -= 1;
    //第三站: 上去两位乘客,下来一位乘客
        count += 2;
        count -= 1;
    //第四站: 下来一位乘客
        count --;
    //第五站: 上去一位乘客
        count ++;
    //请问: 到了终点站,车上还有多少乘客
        return count;
    }
    public static void main(String[] args){
        System.out.print("Final Customer Number: "+ counting());
        // System.out.print(counting());
    }

}
