package io.github.lianjishu.generics.exercise;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <h1>泛型方法的练习</h1>
 * <p>
 * 定义一个工具类：ListUtil
 * <p>
 * 类中定义一个静态方法addAll，用来添加多个集合的元素
 *
 */
public class ListUtil<E> {
    private ListUtil() {
    }

    public static <E> void addAll(ArrayList<E> list, E... e) {
        for (E tmp : e) list.add(tmp);
    }
}
