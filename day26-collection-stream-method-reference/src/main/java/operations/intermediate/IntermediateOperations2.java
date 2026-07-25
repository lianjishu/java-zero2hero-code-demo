package operations.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * distinct     元素去重，依赖(hashCode和equals方法)
 * concat       合并a和b两个流为一个流
 * <p>
 * 注意1：中间方法，返回新的Stream流，原来的Stream流只能使用一次，建议使用链式编程
 * 注意2：修改Stream流中的数据，不会影响原来集合或者数组中的数据
 */
public class IntermediateOperations2 {
    private static ArrayList<String> roster = new ArrayList<>(Arrays.asList(
            "陈佳慧", "周锐妮", "张奕", "刘雅轩", "田梓君", "覃依婷",
            "刘佳鑫", "邓敏敏", "黄琪", "薛凯琪", "龚佳敏", "刘苏",
            "刘佳鑫", "邓敏敏", "黄琪", "薛凯琪", "龚佳敏", "刘苏",
            "刘佳鑫", "邓敏敏", "黄琪", "薛凯琪", "龚佳敏", "刘苏", "刘佳鑫", "邓敏敏", "黄琪", "薛凯琪", "龚佳敏", "刘苏", "刘佳鑫", "邓敏敏", "黄琪", "薛凯琪", "龚佳敏", "刘苏", "刘佳鑫", "邓敏敏", "黄琪", "薛凯琪", "龚佳敏", "刘苏",
            "雷艺萱", "李雨霏", "张秋雯",
            "刘刚", "何俊林", "黄广凡", "王子康", "郭璟文", "龚郁皓", "孙正好", "张逸轩",
            "何炫毅", "谷智坚", "曾钰杰",
            "姜云帆", "周亚科", "申科", "胡佳明", "缪鹏程", "陈飞扬", "王宏胜", "刘俊辉", "曹扬君", "郭旺", "李俊豪",
            "吕涛", "黄绍康", "郑宣", "杨凡", "施文杰", "肖俊彬", "谭哲", "李禺", "吴远帆"
    ));

    private static ArrayList<String> girls = new ArrayList<>(Arrays.asList(
            "陈佳慧", "周锐妮", "张奕", "刘雅轩", "田梓君", "覃依婷", "刘佳鑫", "邓敏敏", "黄琪", "薛凯琪", "龚佳敏",
            "刘苏", "雷艺萱", "李雨霏", "张秋雯"
    ));
    private static ArrayList<String> boys = new ArrayList<>(Arrays.asList(
            "刘刚", "何俊林", "黄广凡", "王子康", "郭璟文", "龚郁皓", "孙正好", "张逸轩",
            "何炫毅", "谷智坚", "曾钰杰",
            "姜云帆", "周亚科", "申科", "胡佳明", "缪鹏程", "陈飞扬", "王宏胜", "刘俊辉",
            "曹扬君", "郭旺", "李俊豪",
            "吕涛", "黄绍康", "郑宣", "杨凡", "施文杰", "肖俊彬", "谭哲", "李禺", "吴远帆"
    ));

    //distinct     元素去重，依赖(hashCode和equals方法)
    private static void testDistinct() {
        roster.stream().distinct().forEach(s -> System.out.print(s + " "));
        System.out.println();
    }

    //concat       合并a和b两个流为一个流
    private static void testConcat() {
        Stream.concat(girls.stream(), boys.stream()).forEach(s -> System.out.print(s + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("//testDistinct");
        testDistinct();
        System.out.println("=====================================\n");

        System.out.println("//testConcat");
        testConcat();
        System.out.println("=====================================\n");
    }
}
