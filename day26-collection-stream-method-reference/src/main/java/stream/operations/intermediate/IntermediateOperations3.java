package stream.operations.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

/**
 * map 转换流中的数据类型
 * <p>
 * 注意1：中间方法，返回新的Stream流，原来的Stream流只能使用一次，建议使用链式编程
 * 注意2：修改Stream流中的数据，不会影响原来集合或者数组中的数据
 */
public class IntermediateOperations3 {
    private static final ArrayList<String> arr = new ArrayList<>(Arrays.asList(
            "張三-1", "李四-2", "王五-3"
    ));

    private static void testMap() {
        arr.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                String[] res = s.split("-");
                return Integer.parseInt(res[1]);
            }
        }).forEach(i-> System.out.print(i+" "));
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("//testMap");
        testMap();
        System.out.println("==================================================");
    }
}
