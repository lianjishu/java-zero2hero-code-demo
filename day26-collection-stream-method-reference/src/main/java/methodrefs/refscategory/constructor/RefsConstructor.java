package methodrefs.refscategory.constructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 方法引用（引用构造方法）
 * 格式
 * 类名::new
 * <p>
 * 目的：
 * 创建这个类的对象
 * <p>
 * 需求：
 * 集合里面存储姓名和年龄，要求封装成 Student 对象并收集到 List 集合中
 * <p>
 * 方法引用的规则：
 * 1. 需要有函数式接口
 * 2. 被引用的方法必须已经存在
 * 3. 被引用方法的形参和返回值，需要跟抽象方法的形参和返回值保持一致
 * 4. 被引用方法的功能需要满足当前的需求
 */
public class RefsConstructor {
    //1. 创建集合对象
    static ArrayList<String> list = new ArrayList<>();

    static {
        // 2. 添加数据
        Collections.addAll(
                list,
                "张无忌,15",
                "周芷若,14",
                "赵敏,13",
                "张强,20",
                "张三丰,100",
                "张翠山,40",
                "张良,35",
                "王二麻子,37",
                "李白,30",
                "李清照,28",
                "李世民,45",
                "王安石,50",
                "王昭君,22",
                "诸葛亮,54",
                "司马懿,70",
                "欧阳锋,66",
                "东方不败,48",
                "慕容复,29",
                "小龙女,24",
                "杨过,25",
                "郭靖,35",
                "黄蓉,34",
                "令狐冲,27",
                "任盈盈,26",
                "张三,8",
                "张小凡,18",
                "张天爱,31",
                "陈近南,60",
                "林平之,21",
                "宋青书,23"
        );
    }

    private static void solution() {
//        List<Student> res = list.stream()
//                .map(new Function<String, Student>() {
//                    @Override
//                    public Student apply(String s) {
//                        String[] split = s.split(",");
//                        return new Student(split[0], Integer.parseInt(split[1]));
//                    }
//                })
//                .collect(Collectors.toList());

        List<Student> res = list.stream()
                .map(Student::new)
                .collect(Collectors.toList());
        System.out.println(res);
    }

    public static void main(String[] args) {
        solution();
    }
}
