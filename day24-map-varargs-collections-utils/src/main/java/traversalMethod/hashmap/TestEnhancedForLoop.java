package traversalMethod.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//练习一：通过键值对对象进行遍历map集合，要求：装着键值对对象的单列集合使用增强for的形式进行遍历
public class TestEnhancedForLoop {
    public static <K, V> void test(Map<K, V> hashMap) {
        //获取EntrySet
        Set<Map.Entry<K, V>> entrySet = hashMap.entrySet();
        //使用Enhanced for loop
        for (Map.Entry<K,V> entry : entrySet) {
            System.out.printf("%s->%s%n", entry.getKey(), entry.getValue());
        }
    }
}
