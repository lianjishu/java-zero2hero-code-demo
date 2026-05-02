package io.github.lianjishu.Day06_Method;

public class SwapArrNum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("交换前: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println(" ");
//        for (int i = 0; i < arr.length; i++) {
//            int temp = arr[i];
//            arr[i] = arr[arr.length-1-i];
//            arr[arr.length-1-i] = temp;
//        }
        for (int i = 0,j=arr.length-1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        System.out.println("交换后: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

    }
}
