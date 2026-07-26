package methodrefs.refscategory.staticmethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 方法引用（引用静态方法）
 * 格式
 * 类::方法名
 * <p>
 * 需求：
 * 集合中有以下数字，要求把他们都变成int类型
 * "1","2","3","4","5"
 */
public class RefsStaticMethod {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        Collections.addAll(al, "1", "2", "3", "4", "5");

        List<Integer> integers = al.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(integers);
    }
}
