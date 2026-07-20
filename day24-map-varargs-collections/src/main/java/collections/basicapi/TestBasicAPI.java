package collections.basicapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TestBasicAPI {
    private static void testAddAll() {
        System.out.println("// testAddAll");
        ArrayList<String> al = new ArrayList<>();
        Collections.addAll(al, "q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d");
        System.out.println(al);
        System.out.println("// ===============================\n");
    }

    private static void testShuffle() {
        System.out.println("// testShuffle");
        ArrayList<String> al = new ArrayList<>();
        Collections.addAll(al, "q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d");
        Collections.shuffle(al);
        System.out.println(al);
        System.out.println("// ===============================\n");
    }

    private static void testSort() {
        System.out.println("// testSort");
        ArrayList<String> al = new ArrayList<>();
        Collections.addAll(al, "q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d");
        Collections.sort(al, String::compareToIgnoreCase);
        System.out.println(al);
        Collections.sort(al, (s1, s2) -> s2.compareToIgnoreCase(s1));
        System.out.println(al);
        System.out.println("// ===============================\n");


    }

    private static void testBinarySearch() {
        System.out.println("// testBinarySearch");
        ArrayList<String> al = new ArrayList<>();
        Collections.addAll(al, "q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d");
        System.out.println("bs(al, w) = " + Collections.binarySearch(al, "w"));
        System.out.println("// ===============================\n");
    }

    //❌  失败原因:Collections.copy(dest, src) 参数顺序反了 → (al, alCopied),源是空 list,自然拷不到东西
    private static void testCopy() {
        System.out.println("// testCopy");
        ArrayList<String> al = new ArrayList<>();
        Collections.addAll(al, "q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d");
        ArrayList<String> alCopied = new ArrayList<>(al);   // 先准备一份同 size 的目标
        Collections.copy(alCopied, al);                    // ★ 顺序:dest 在前,src 在后
        System.out.println("al = " + al);
        System.out.println("alCopied = " + alCopied);
        System.out.println("// ===============================\n");
    }

    //❌  失败原因:fill 只替换已有位置 [0, size),不会扩容;al 是空 list → 啥也没填
    private static void testFill() {
        System.out.println("// testFill");
        ArrayList<String> al = new ArrayList<>();
        Collections.addAll(al, "q", "w", "e", "r", "t");  // ★ 先占位
        Collections.fill(al, "旛鷤孳");                   // 再 fill
        System.out.println(al);
        System.out.println("// ===============================\n");
    }

    private static void testMaxMin() {
        System.out.println("// testMaxMin");
        ArrayList<String> al = new ArrayList<>();
        Collections.addAll(al, "q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d");
        System.out.println("get min by natural sort = " + Collections.min(al));
        System.out.println("get max by natural sort = " + Collections.max(al));
        System.out.println("// ===============================\n");
    }

    private static void testSwap() {
        System.out.println("// testSwap");
        ArrayList<String> al = new ArrayList<>();
        Collections.addAll(al, "q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d");
        System.out.println(al);
        Collections.swap(al, 0, al.size() - 1);
        System.out.println("Collections.swap(al, 0, size-1)...");
        System.out.println(al);
        System.out.println("// ===============================\n");
    }

    public static void main(String[] args) {
        testAddAll();
        testShuffle();
        testSort();
        testBinarySearch();
        testCopy();
        testFill();
        testMaxMin();
        testSwap();
    }
}
