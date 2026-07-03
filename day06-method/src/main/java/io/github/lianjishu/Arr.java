package io.github.lianjishu;
public class Arr {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int[] arra = new int[] {1,2,3,4,5,6,7,8,9};

        for(int i=0; i<arr.length; ++i){
            System.out.println(arr[i]);
        }
        System.out.println("-----------------------------");
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
