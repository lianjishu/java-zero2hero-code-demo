package io.github.lianjishu.timeclass.jdk7.simpledateformat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SdfDemo {
    public static void main(String[] args) {
        //1.利用空参构造创建SimpleDateFormat对象, 默认格式
        SimpleDateFormat sdf1 = new SimpleDateFormat();
        Date d1 = new Date(0L);
        String str1 = sdf1.format(d1);
        System.out.println(str1);

        //2.利用带参构造创建SimpleDateFormate对象, 指定格式
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String str2 = sdf2.format(d1);
        System.out.println(str2);

        //3.年份中的周数
        System.out.println(new SimpleDateFormat("yyyy年有w周").format(new Date()));
        //4.星期几
        System.out.println(new SimpleDateFormat("今天是EE").format(new Date()));

    }
}
