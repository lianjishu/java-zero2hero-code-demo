package map.treemap.exerciseB;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * 需求是：统计字符串 "aababcabcdabcde" 中每个字符出现的次数，并按照"字符 (次数)"的格式输出。
 * 预期结果：
 * a (5) b (4) c (3) d (2) e (1)
 */
public class Main {
    public static void main(String[] args) {
        String str = "aababcabcdabcde";
        TreeMap<Character, Integer> treeMap = new TreeMap<>(
                Comparator.comparingInt((Character c) -> c)
        );
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if (treeMap.containsKey(c))
                treeMap.put(c, treeMap.get(c) + 1);
            else
                treeMap.put(c, 1);
        }
        treeMap.forEach(
                (k, v) -> System.out.printf("%c (%d) ", k, v)
        );

    }
}
