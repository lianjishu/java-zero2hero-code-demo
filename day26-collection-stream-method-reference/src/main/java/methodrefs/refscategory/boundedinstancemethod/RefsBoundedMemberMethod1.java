package methodrefs.refscategory.boundedinstancemethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 方法引用（引用成员方法）
 * 格式
 * 其他类：其他类对象::方法名
 * 本类：this::方法名
 * 父类：super::方法名
 * <p>
 * 需求：
 * 集合中有一些名字，按照要求过滤数据
 * 数据："张无忌"，"周芷若"，"赵敏"，"张强"，"张三丰"
 * 要求：只要以"张"开头，而且名字是3个字的
 */
public class RefsBoundedMemberMethod1 {
    private static ArrayList<String> roster = new ArrayList<>();

    static {
        Collections.addAll(roster, "张无忌", "周芷若", "赵敏", "张强", "张三丰");
    }

    public static void main(String[] args) {
        List<String> res = roster.stream()
                .filter(new RefsBoundedMemberMethod1()::filterRule)
                .collect(Collectors.toList());
        System.out.println(res);
    }

    private boolean filterRule(String s) {
        return s.startsWith("张") && s.length() == 3;
    }
}
