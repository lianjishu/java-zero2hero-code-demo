package io.github.lianjishu.generics.exercise;

import java.util.ArrayList;

public class TestListUtil {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ListUtil.addAll(list1, 1, 2, 3);
        System.out.println("list1 = " + list1);

        ArrayList<String> list2 = new ArrayList<>();
        ListUtil.addAll(list2, "ONE", "TWO", "THREE");
        System.out.println("list2 = " + list2);

    }
}
