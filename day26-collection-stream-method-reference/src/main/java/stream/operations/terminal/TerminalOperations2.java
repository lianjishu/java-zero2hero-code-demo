package stream.operations.terminal;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * collect(Collector collector)    收集流中的数据，放到集合中 (List Set Map)
 * <p>
 * 注意点：
 * 如果我们要收集到Map集合当中，键不能重复，否则会报错
 */
public class TerminalOperations2 {
    static ArrayList<String> list = new ArrayList<>();

    static {
        Collections.addAll(list, "张无忌-男-15", "周芷若-女-14", "赵敏-女-13", "张强-男-20",
                "张三丰-男-100", "张翠山-男-40", "张良-男-35", "王二麻子-男-37", "谢广坤-男-41"
        );
    }

    /**
     * 需求：
     * 收集到List集合当中
     * 我要把所有的男性收集起来
     */
    private static void testCollectCollectorToList() {
        List<String> menList = list.stream()
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        return "男".equals(s.split("-")[1]);
                    }
                })
                .collect(Collectors.toList());
        System.out.println("menList: " + menList);
    }

    /**
     * 需求：
     * 收集到Set集合当中
     * 我要把所有的男性收集起来
     */
    private static void testCollectCollectorToSet() {
        Set<String> menSet = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toSet());
        System.out.println("menSet: " + menSet);
    }

    /**
     * 需求：
     * 收集到Map集合当中
     * 我要把所有的男性收集起来, 键值对格式: 姓名=年龄
     */
    private static void testCollectCollectorToMap() {
        Map<String, Integer> menMap = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toMap(
                        new Function<String, String>() {
                            @Override
                            public String apply(String s) {
                                return s.split("-")[0];
                            }
                        },
                        new Function<String, Integer>() {
                            @Override
                            public Integer apply(String s) {
                                return Integer.parseInt(s.split("-")[2]);
                            }
                        })
                );
        System.out.println("menMap: " + menMap);
    }

    public static void main(String[] args) {
        testCollectCollectorToList();
        testCollectCollectorToSet();
//        注意点：
//        如果我们要收集到Map集合当中，键不能重复，否则会报错
        testCollectCollectorToMap();
    }
}
