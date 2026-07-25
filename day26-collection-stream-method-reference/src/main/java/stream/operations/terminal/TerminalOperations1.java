package stream.operations.terminal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.IntFunction;

/**
 * void forEach(Consumer action)    遍历
 * long count()                     统计
 * toArray()                        收集流中的数据，放到数组中
 */
public class TerminalOperations1 {
    static ArrayList<String> list = new ArrayList<>();

    static {
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰", "张翠山", "张良", "王二麻子", "谢广坤");
    }

    private static void testForEach() {
        list.stream().forEach(System.out::println);
    }

    private static void testCount() {
        System.out.println(list.stream().count());
    }

    private static void testToArray() {
        Object[] objList = list.stream().toArray();
        System.out.println(Arrays.toString(objList));
        String[] array = list.stream().toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        testCount();
        testForEach();
        testToArray();
    }
}
