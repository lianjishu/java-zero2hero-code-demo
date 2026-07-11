package io.github.lianjishu.Arrays;

import java.util.Arrays;

public class TestBasicArraysAPI {

    private static void testToString() {
        System.out.println("# ======================================");
        System.out.println("# ============ toString ================");
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    private static void testBinarySearch() {
        //数组元素必须是有序的!!!
        System.out.println("# ======================================");
        System.out.println("# =========== binarySearch =============");
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        System.out.printf("binarySearch(2)%n", Arrays.binarySearch(arr, 2));
        System.out.printf("binarySearch(12)%n", Arrays.binarySearch(arr, 12));
        System.out.println();
    }

    private static void testCopyOf() {
        System.out.println("# ======================================");
        System.out.println("# =============== copyOf ===============");
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        var arr2 = Arrays.copyOf(arr, arr.length * 2);
        System.out.printf("arr2=%s%n", Arrays.toString(arr2));
        System.out.println();

    }

    private static void testCopyOfRange() {
        System.out.println("# ======================================");
        System.out.println("# ============= copyOfRange =============");
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        var arr2 = Arrays.copyOfRange(arr, 0, 1);
        System.out.printf("arr2=%s%n", Arrays.toString(arr2));
        System.out.println();

    }

    public static void main(String[] args) {
        testToString();
        testBinarySearch();
        testCopyOf();
        testCopyOfRange();
    }
}
