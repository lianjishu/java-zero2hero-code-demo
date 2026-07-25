package stream.exercise.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * 数据操作
 * <p>
 * 现在有两个ArrayList集合，
 * <br>
 * 第一个集合中：存储6名男演员的名字和年龄。第二个集合中：存储6名女演员的名字和年龄。
 * <br>
 * 姓名和年龄中间用逗号隔开。比如：张三,23
 * <br>
 * 要求完成如下的操作：
 * <br>
 * 1. 男演员只要名字为3个字的前两人
 * <br>
 * 2. 女演员只要姓杨的，并且不要第一个
 * <br>
 * 3. 把过滤后的男演员姓名和女演员姓名合并到一起
 * <br>
 * 4. 将上一步的演员信息封装成Actor对象。
 * <br>
 * 5. 将所有的演员对象都保存到List集合中。
 * <p>
 * 备注：演员类Actor，属性有：name，age
 */
public class ActorStreamPractice {
    static ArrayList<String> actors = new ArrayList<>();
    static ArrayList<String> actress = new ArrayList<>();

    static {
        Collections.addAll(actors,
                "刘德华,61",
                "张学友,62",
                "郭富城,58",
                "黎明,56",
                "周星驰,60",
                "成龙,69"
        );

        Collections.addAll(actress,
                "杨幂,36",
                "杨紫,30",
                "高圆圆,43",
                "刘亦菲,35",
                "杨颖,34",
                "唐嫣,39"
        );
    }

    private static List<Actor> solution() {
        List<Actor> list = new ArrayList<>();

        //把过滤后的男演员姓名和女演员姓名合并到一起
        Stream.concat(
                //男演员只要名字为3个字的前两人
                actors.stream()
                        .filter(s -> s.split(",")[0].length() == 3)
                        .limit(2),
                //女演员只要姓杨的，并且不要第一个
                actress.stream()
                        .filter(s -> s.startsWith("杨"))
                        .skip(1)
        ).forEach(s -> list.add(//将所有的演员对象都保存到List集合中
                new Actor(//将上一步的演员信息封装成Actor对象
                        s.split(",")[0],
                        Integer.parseInt(s.split(",")[1])
                )
        ));

        return list;
    }

    public static void main(String[] args) {
        System.out.println(solution());
    }
}
