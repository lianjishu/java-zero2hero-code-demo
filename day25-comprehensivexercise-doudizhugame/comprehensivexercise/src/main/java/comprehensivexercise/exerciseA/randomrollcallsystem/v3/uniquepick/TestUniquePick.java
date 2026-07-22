package comprehensivexercise.exerciseA.randomrollcallsystem.v3.uniquepick;

import java.util.ArrayList;
import java.util.Arrays;

public class TestUniquePick {
    private static ArrayList<String> roster = new ArrayList<>(Arrays.asList(
            "陈佳慧", "周锐妮", "张奕", "刘雅轩", "田梓君", "覃依婷", "刘佳鑫", "邓敏敏", "黄琪", "薛凯琪", "龚佳敏",
            "刘苏", "雷艺萱", "李雨霏", "张秋雯", "刘刚", "何俊林", "黄广凡", "王子康", "郭璟文", "龚郁皓", "孙正好", "张逸轩", "何炫毅", "谷智坚", "曾钰杰",
            "姜云帆", "周亚科", "申科", "胡佳明", "缪鹏程", "陈飞扬", "王宏胜", "刘俊辉", "曹扬君", "郭旺", "李俊豪",
            "吕涛", "黄绍康", "郑宣", "杨凡", "施文杰", "肖俊彬", "谭哲", "李禺", "吴远帆"
    ));

    public static void main(String[] args) {
        UniquePick pick = new UniquePick();
        pick.receive(roster);
        System.out.println(pick.selectName(46));
    }
}
