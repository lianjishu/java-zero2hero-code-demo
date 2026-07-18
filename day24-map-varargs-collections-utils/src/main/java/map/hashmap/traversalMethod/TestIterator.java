package map.hashmap.traversalMethod;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 练习二：通过键值对对象进行遍历map集合，要求：装着键值对对象的单列集合使用迭代器的形式进行遍历
 */
public class TestIterator {
    public static <K, V> void test(Map<K, V> hashMap) {
        //获取EntrySet
        Set<Map.Entry<K, V>> entrySet = hashMap.entrySet();
        //使用Iterator
        Iterator<Map.Entry<K, V>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<K, V> entry = iterator.next();
            System.out.printf(
                    "%s->%s%n",
                    entry.getKey(),
                    entry.getValue()
            );
        }

    }
}
