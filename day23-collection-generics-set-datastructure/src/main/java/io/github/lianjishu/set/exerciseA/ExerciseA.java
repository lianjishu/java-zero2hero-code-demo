package io.github.lianjishu.set.exerciseA;

import java.util.*;

/**
 * 存储字符串并遍历
 * <p>
 * 利用Set系列的集合，添加字符串，并使用多种方式遍历。
 * <ul>
 *     <li>① 迭代器</li>
 *     <li>② 增强for</li>
 *     <li>③ Lambda表达式</li>
 * </ul>
 */

public class ExerciseA {
    private static HashSet<String> logicStruct = new HashSet<>(Set.of("Set Structure", "Linear Structure", "Tree Structure", "Graph Structure"));

    private static void withIterator() {
        System.out.println("Iterator...");
        Iterator iterator = logicStruct.iterator();
        System.out.print("[ ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("]");
    }

    private static void withAdvancedFor() {
        System.out.println("Advanced For Loop...");
        System.out.print("[ ");
        for (var e : logicStruct) {
            System.out.print(e + " ");
        }
        System.out.println("]");
    }

    public static void withLambda() {
        System.out.println("Lambda...");
        System.out.print("[ ");
        logicStruct.forEach(e -> System.out.print(e + " "));
        System.out.println("]");
    }

    public static void main(String[] args) {
        withIterator();
        withAdvancedFor();
        withLambda();
    }
}
