package methodrefs.tryout;

import java.util.Arrays;
import java.util.Comparator;

public class TryOutMethodRefs {
    private static void WithAnonymousInnerClass() {
        //需求: 创建一个数组,进行倒序排列
        Integer[] arr = {3, 5, 4, 1, 6, 2};
        //匿名内部类
        Arrays.sort(arr, new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println("//匿名内部类");
        System.out.println(Arrays.toString(arr));
        System.out.println("===================\n");
    }

    private static void WithLambda() {
        //需求: 创建一个数组,进行倒序排列
        Integer[] arr = {3, 5, 4, 1, 6, 2};

        //lambda 表达式
        Arrays.sort(arr, (Integer o1, Integer o2) -> {
            return o2 - o1;
        });
        System.out.println("//lambda 表达式");
        System.out.println(Arrays.toString(arr));
        System.out.println("===================\n");
    }

    private static void WithSimplifiedLambda() {
        //需求: 创建一个数组,进行倒序排列
        Integer[] arr = {3, 5, 4, 1, 6, 2};
        //lambda 表达式简化格式
        Arrays.sort(arr, (o1, o2) -> o2 - o1);
        System.out.println("//lambda 表达式简化格式");
        System.out.println(Arrays.toString(arr));
        System.out.println("===================\n");
    }

    private static void WithMethodRefs() {
        //需求: 创建一个数组,进行倒序排列
        Integer[] arr = {3, 5, 4, 1, 6, 2};
        //方法引用
        Arrays.sort(arr, TryOutMethodRefs::subtraction);
        System.out.println("//方法引用");
        System.out.println(Arrays.toString(arr));
        System.out.println("===================\n");
    }

    public static void main(String[] args) {
        WithAnonymousInnerClass();
        WithLambda();
        WithSimplifiedLambda();
        WithMethodRefs();
    }

    public static int subtraction(int num1, int num2) {
        return num2 - num1;
    }

}
