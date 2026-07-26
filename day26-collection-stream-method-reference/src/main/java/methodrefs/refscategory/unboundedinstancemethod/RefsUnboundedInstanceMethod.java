package methodrefs.refscategory.unboundedinstancemethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 方法引用（类名调用成员方法）
 * 格式
 * 类名::成员方法
 * <p>
 * 需求：
 * 集合里面一些字符串，要求变成大写后进行输出
 */
public class RefsUnboundedInstanceMethod {
    //1. 创建集合对象
    static ArrayList<String> list = new ArrayList<>();

    static {
        //2. 添加数据
        Collections.addAll(list, "aaa", "bbb", "ccc", "ddd");
    }

    private static void solution() {
//        List<String> result = list.stream()
//                .map(new Function<String, String>() {
//                    @Override
//                    public String apply(String s) {
//                        return s.toUpperCase();
//                    }
//                }).collect(Collectors.toList());

        /**对于 类名::成员方法，
         * 抽象方法的第一个形参，会被当成“调用这个成员方法的对象”；
         * 从第二个形参开始，才对应被引用成员方法自己的参数。*/

        /**这种格式并不能引用所有的类中的成员方法
         * 取决于函数式接口中的那个抽象方法的第一个形参类型
         * 本例中`public String apply(String s)` 是String
         * 那么只能引用String instance中的方法*/

        List<String> result = list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(result);
    }


    public static void main(String[] args) {
        solution();
    }
}
