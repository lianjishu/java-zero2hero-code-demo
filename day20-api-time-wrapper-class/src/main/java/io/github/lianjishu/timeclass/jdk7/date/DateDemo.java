package io.github.lianjishu.timeclass.jdk7.date;

import java.util.Date;

/**
 * public Date()    创建Date对象，表示当前时间
 * public Date(long date) 创建Date对象，表示指定时间
 * <p>
 * public void setTime(long time)    设置/修改毫秒值
 * public long getTime()    获取时间对象的毫秒值
 */
public class DateDemo {
    public static void main(String[] args) {
        //1.创建对象表示一个时间
        Date d1 = new Date();
        System.out.println(d1);

        //2.创建对象表示一个指定的时间
        Date d2 = new Date(0L);
        System.out.println(d2);

        //3.手动修改时间
        Date d3 = new Date();
        d3.setTime(10000L);
        System.out.println(d3);

        //获取当前时间的毫秒值
        Date d4 = new Date();
        System.out.println(d4.getTime());
    }
}
