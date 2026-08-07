package io.github.lianjishu.timeclass.jdk7.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
    public static void main(String[] args) {
        Date d = new Date(); //今天
        Calendar c = Calendar.getInstance();
        c.setTime(d);

        //解剖
        System.out.println("Date = " + new SimpleDateFormat("yyyy年MM月dd日 HH:mm EE").format(d));
        int year = c.get(Calendar.YEAR);
        System.out.println("年: " + year);
        int month = c.get(Calendar.MONTH) + 1;
        System.out.println("月: " + month);
        int day = c.get(Calendar.DAY_OF_MONTH);
        System.out.println("日: " + day);
        int week = c.get(Calendar.DAY_OF_WEEK);
        System.out.println("星期: " + week);
    }
}
