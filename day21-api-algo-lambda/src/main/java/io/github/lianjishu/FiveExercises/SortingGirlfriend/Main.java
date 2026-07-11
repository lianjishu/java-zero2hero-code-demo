package io.github.lianjishu.FiveExercises.SortingGirlfriend;

import java.util.Arrays;

/**
 * 练习 按照要求进行排序
 * 定义数组并存储一些女朋友对象，利用Arrays中的sort方法进行排序
 * 要求1：属性有姓名、年龄、身高。
 * 要求2：按照年龄的大小进行排序，年龄一样，按照身高排序，身高一样按照姓名的字母进行排序。
 * （姓名中不要有中文或特殊字符，会涉及到后面的知识）
 */
public class Main {
    public static void main(String[] args) {
        Girlfriend[] girlFriends = {
                new Girlfriend("Alice", 24, 168.5, 88.0, 62.0, 92.0),
                new Girlfriend("Bob", 26, 172.0, 90.0, 65.0, 95.0),
                new Girlfriend("Carol", 24, 165.0, 86.0, 60.0, 90.0),
                new Girlfriend("David", 25, 175.0, 92.0, 68.0, 98.0),
                new Girlfriend("Eve", 23, 160.0, 82.0, 58.0, 88.0),
                new Girlfriend("Frank", 26, 178.0, 95.0, 70.0, 100.0),
                new Girlfriend("Grace", 24, 165.0, 85.0, 61.0, 89.0)
                // 注意：Grace和Carol年龄、身高一样，会按名字字母排序
        };

        System.out.println(Arrays.toString(girlFriends));

        Arrays.sort(girlFriends, (Girlfriend o1, Girlfriend o2) -> {
            int byAge = Integer.compare(o1.getAge(), o2.getAge());
            int byHeight = Double.compare(o1.getHeight(), o2.getHeight());
            int byName = o1.getName().compareToIgnoreCase(o2.getName());

            // Early Return: byAge -> byHeight -> byName
            if (byAge != 0)
                return byAge;
            if (byHeight != 0)
                return byHeight;
            return byName;
        });

        System.out.println(Arrays.toString(girlFriends));
    }

}
