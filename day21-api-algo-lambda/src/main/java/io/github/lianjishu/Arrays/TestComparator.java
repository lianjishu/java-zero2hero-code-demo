package io.github.lianjishu.Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class TestComparator {
    private static int[] primitiveArr = { 3, 5, 2, 1, 4 };
    private static Integer[] boxedArr = Arrays.stream(primitiveArr)
            .boxed()
            .toArray(Integer[]::new);

    public static void testComparator() {
        Arrays.sort(boxedArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println("----------");
                System.out.println("o1: " + o1);
                System.out.println("o2: " + o2);

                return o1 - o2;
            }
        });
        System.out.println("boxedArr = " + Arrays.toString(boxedArr));
    }

    public static void main(String[] args) {
        testComparator();
    }

}
