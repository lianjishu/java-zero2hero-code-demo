package io.github.lianjishu;

import java.util.Random;
/*打乱数组元素*/
//打乱一维数组的元素, 并且按照4个一组的方式添加到二维数组中
public class Scramble {
    static private int[] arr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
    static public void printer(int[] array) {
        System.out.print("[");
        for(int i=0; i<array.length; ++i) {
            System.out.print(array[i]);
            if(i != array.length-1)
                System.out.print(", ");
        }
        System.out.println("]");
    }
    static public void solution() {
        //遍历数组每一个元素, 对当前元素与一个随机索引的元素交换
        Random random = new Random();
        for(int i=0; i<arr.length; ++i) {
            int rIdx = random.nextInt(arr.length);
            var tmp = arr[i];
            arr[i] = arr[rIdx];
            arr[rIdx] = tmp;
        }
    }

    public static void main(String[] args) {
        printer(arr);
        solution();
        printer(arr);
    }
}
