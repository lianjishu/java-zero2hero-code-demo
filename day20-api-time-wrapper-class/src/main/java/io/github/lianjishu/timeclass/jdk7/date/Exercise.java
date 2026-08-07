package io.github.lianjishu.timeclass.jdk7.date;

import java.util.Date;
import java.util.Random;

/**
 * # 练习
 * <p>
 * ## 时间计算
 * <p>
 * 需求1：打印时间原点开始一年之后的时间
 * 需求2：定义任意两个Date对象，比较一下哪个时间在前，哪个时间在后
 */
public class Exercise {
    private static void foo() {
        Date epoch = new Date(0L);
        Date epochAfterAYear = new Date(epoch.getTime() + 365L * 24 * 60 * 60 * 1000);

        System.out.println("Unix Epoch: " + epoch);
        System.out.println("After a Year: " + epochAfterAYear);
    }

    private static void bar() {
        Random r = new Random();
        Date d1 = new Date(Math.abs(r.nextLong()));
        Date d2 = new Date(Math.abs(r.nextLong()));
        System.out.println("d1: " + d1 + "   |  " + "d2: " + d2);
        System.out.println("d1 is before d2? " + d1.before(d2));
    }


    public static void main(String[] args) {
        foo();
        System.out.println("==================================");
        bar();
    }
}
