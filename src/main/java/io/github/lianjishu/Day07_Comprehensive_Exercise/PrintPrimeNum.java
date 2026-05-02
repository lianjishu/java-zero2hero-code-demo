package io.github.lianjishu.Day07_Comprehensive_Exercise;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * 判断101~200之间有多少个素数，并输出所有素数。
 */
public class PrintPrimeNum {
    static ArrayList<ArrayList<Integer>> nums = new ArrayList<>(100);

    static void initArrayList(int begin, int end) {
        for(int i=begin; i<=end; ++i) {
            ArrayList<Integer> row = new ArrayList<>(Arrays.asList(i, 0));
            nums.add(row);
        }
    }

    static boolean isPrime(int num) {
        for(int i=2; i<num; ++i) {
            if(num % i == 0)
                return false;
        }
        return true;
    }

    static void tagging(ArrayList<Integer> pair) {
        pair.set(1, 1);
    }

    static void printer(ArrayList<Integer> arrayList) {
        System.out.print("[");
        for(int i=0; i<arrayList.size(); ++i) {
            System.out.print(arrayList.get(i));
            if(i != arrayList.size()-1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Iterator<ArrayList<Integer>> it = nums.iterator();
        initArrayList(101, 200);
        ArrayList<Integer> result = new ArrayList<>();
        var count = 0;
        for (var pair : nums) {
            if (isPrime(pair.getFirst())) {
                tagging(pair);
                count ++;
                result.add(pair.getFirst());
            }
        }
        System.out.println("Count = " + count);
        printer(result);
    }
}