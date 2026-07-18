package map.hashmap.traversalMethod;

import java.util.Map;
import java.util.Set;

/**
 * 练习三：通过键值对对象进行遍历map集合，要求：装着键值对对象的单列集合使用lambda的形式进行遍历
 */
public class TestLambda {
    public static <K, V> void test(Map<K, V> hashMap) {
        //获取EntrySet
        Set<Map.Entry<K, V>> entrySet = hashMap.entrySet();
        //使用lambda
        entrySet.forEach(
                kvEntry -> System.out.printf(
                        "%s->%s%n",
                        kvEntry.getKey(),
                        kvEntry.getValue())
        );
    }
}
