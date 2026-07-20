package map.hashmap.traversalMethod;
/**
 * Map集合的第二种遍历方式
 */

import java.util.HashMap;

/**
 * 三个课堂练习：
 * <p>
 * 练习一：通过键值对对象进行遍历map集合，要求：装着键值对对象的单列集合使用增强for的形式进行遍历
 * 练习二：通过键值对对象进行遍历map集合，要求：装着键值对对象的单列集合使用迭代器的形式进行遍历
 * 练习三：通过键值对对象进行遍历map集合，要求：装着键值对对象的单列集合使用lambda的形式进行遍历
 */
public class HashMapTraversalMethod {
    private static HashMap<String, String> getMockData() {
        HashMap<String, String> data = new HashMap<>();
        data.put("青莲剑仙", "李白");
        data.put("街头霸王", "韩信");
        data.put("魅惑之狐", "妲己");
        data.put("寒冰公主", "王昭君");
        data.put("绝代智谋", "诸葛亮");
        data.put("远游探险家", "马可波罗");
        data.put("齐天大圣", "孙悟空");
        data.put("月光之女", "露娜");
        data.put("机关造物", "鲁班七号");
        data.put("治愈之音", "蔡文姬");
        data.put("战争之王", "夏侯惇");
        data.put("信念之刃", "阿轲");
        data.put("千里走单骑", "关羽");
        data.put("不灭魔躯", "铠");
        data.put("离", "公孙离");
        return data;
    }

    public static void main(String[] args) {
        HashMap<String, String> data = getMockData();
        TestEnhancedForLoop.test(data);
        System.out.println("======================================================");
        TestIterator.test(data);
        System.out.println("======================================================");
        TestLambda.test(data);
        System.out.println("======================================================");
    }
}
