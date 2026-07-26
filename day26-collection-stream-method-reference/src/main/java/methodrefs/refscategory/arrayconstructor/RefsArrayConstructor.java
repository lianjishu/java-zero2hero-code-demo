package methodrefs.refscategory.arrayconstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

/**
 * 方法引用（数组的构造方法）
 * 格式
 * 数据类型[]::new
 * <p>
 * 目的：
 * 创建一个指定类型的数组
 * <p>
 * 需求：
 * 集合中存储一些整数，收集到数组当中
 */
public class RefsArrayConstructor {
    private static ArrayList<Integer> al = new ArrayList<>();

    static {
        Collections.addAll(al, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    private static void solution() {
        //集合转数组
//        Integer[] array = al.stream().toArray(new IntFunction<Integer[]>() {
//            @Override
//            public Integer[] apply(int value) {
//                return new Integer[value];
//            }
//        });
        Integer[] array = al.stream().toArray(Integer[]::new);
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        solution();
    }
}
