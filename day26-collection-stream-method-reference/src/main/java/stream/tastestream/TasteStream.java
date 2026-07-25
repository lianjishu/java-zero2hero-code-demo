package stream.tastestream;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * 创建集合添加元素, 完成一下需求:
 * 1. 把所有的以"张"开头的元素存储到新集合中
 * 2. 把"张"开头的, 长度为3的元素再存储到新集合中
 * 3. 遍历打印最终的结果
 */
public class TasteStream {
    private static void withoutStream() {
        //创建集合添加元素
        ArrayList<String> al1 = new ArrayList<>();
        Collections.addAll(al1,
                "张伟", "张三丰", "张无忌",
                "张翠山", "张小凡", "李强",
                "王芳", "张亮", "刘洋",
                "张一山", "赵敏", "张飞",
                "周芷若", "张嘉译", "陈明",
                "王建国", "刘德华", "李小龙",
                "赵本山", "周杰伦", "陈道明",
                "杨幂", "孙俪", "黄晓明",
                "吴京");

        //把所有的以"张"开头的元素存储到新集合中
        ArrayList<String> al2 = new ArrayList<>();
        for (String e : al1)
            if (e.startsWith("张")) al2.add(e);

        //把"张"开头的, 长度为3的元素再存储到新集合中
        ArrayList<String> al3 = new ArrayList<>();
        for (String e : al2)
            if (e.length() == 3) al3.add(e);

        //遍历打印最终的结果
        System.out.println("//所有人名");
        System.out.printf("al1 = %s%n", al1);
        System.out.println();

        System.out.println("//以\"张\"开头的元素");
        System.out.printf("al2 = %s%n", al2);
        System.out.printf("");

        System.out.println("//\"张\"开头的, 长度为3的元素");
        System.out.printf("al3 = %s%n", al3);
        System.out.println();

    }

    private static void withStream() {
        //创建集合添加元素, 完成一下需求
        ArrayList<String> al1 = new ArrayList<>();
        Collections.addAll(al1,
                "张伟", "张三丰", "张无忌",
                "张翠山", "张小凡", "李强",
                "王芳", "张亮", "刘洋",
                "张一山", "赵敏", "张飞",
                "周芷若", "张嘉译", "陈明",
                "王建国", "刘德华", "李小龙",
                "赵本山", "周杰伦", "陈道明",
                "杨幂", "孙俪", "黄晓明",
                "吴京");


        al1.stream()
                .filter(s -> s.startsWith("张")) //把所有的以"张"开头的元素存储到新集合中
                .filter(s -> s.length() == 3).toList() //把"张"开头的, 长度为3的元素再存储到新集合中
                .forEach(s -> System.out.println(s)); //遍历打印最终的结果

    }

    public static void main(String[] args) {
        withoutStream();
        System.out.println("\n===========================================\n");
        withStream();
    }
}
