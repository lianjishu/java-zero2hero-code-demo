package stream.exercise.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 练习
 * <p>
 * 数据操作
 * <p>
 * 练习：
 * <br>
 * 创建一个ArrayList集合，并添加以下字符串，字符串中前面是姓名，后面是年龄
 * <br>
 * "zhangsan, 23"
 * <br>
 * "lisi, 24"
 * <br>
 * "wangwu, 25"
 * <br>
 * 保留年龄大于等于24岁的人，并将结果收集到Map集合中，姓名为键，年龄为值
 */
public class StreamMapCollectPractice {
    static ArrayList<String> infomation = new ArrayList<>();

    static {
        Collections.addAll(infomation, "zhangsan, 23", "lisi, 24", "wangwu, 25");
    }

    private static Map<String, Integer> solution() {
        return infomation.stream()
                .filter(s->24<=Integer.parseInt(s.split(", ")[1]))
                .collect(Collectors.toMap(
                        s -> s.split(", ")[0],
                        s -> Integer.parseInt(s.split(", ")[1])
                ));
    }

    public static void main(String[] args) {
        System.out.println("result: " + solution());
    }
}
