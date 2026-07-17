package io.github.lianjishu.set.exerciseE;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * TreeSet 对象排序练习题
 *
 * <p>
 * 需求：请自行选择比较器排序和自然排序两种方式；
 * </p>
 *
 * <p>
 * 要求：存入四个字符串 "c","ab","df","qwer"，按照长度排序，
 * 如果一样长则按照首字母排序。
 * </p>
 */
public class ExerciseE {
    private static final String[] mockData = new String[] {
            "c", "ab", "df", "qwer"
    };

    private static void TestWithComparator() {
        System.out.println("TestWithComparator...");
        TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            // 按照长度排序，如果一样长则按照首字母排序。
            public int compare(String o1, String o2) {
                if (o1.length() == 0 && o2.length() == 0)
                    return 0;
                int byLength = o1.length() - o2.length();
                if (byLength != 0)
                    return byLength;
                return o1.charAt(0) - o2.charAt(0);
            }
        });

        for (var e : mockData)
            treeSet.add(e);
        System.out.println(treeSet);

    }

    // String 的compareTo是字典序
    // private static void TestWithNaturalSorting() {
    // System.out.println("TestWithNaturalSorting...");
    // TreeSet<String> treeSet = new TreeSet<>();
    // for (var e : mockData)
    // treeSet.add(e);
    // System.out.println(treeSet);
    // }

    public static void main(String[] args) {
        TestWithComparator();
        // TestWithNaturalSorting();
    }
}
