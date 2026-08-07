package io.github.lianjishu.timeclass.jdk7.simpledateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 练习
 * <p>
 * 按照指定格式展示
 * <p>
 * 假设，你初恋的出生年月日为：2000-11-11
 * <p>
 * 请用字符串表示这个数据，并将其转换为：2000年11月11日
 */
public class Exercise {
    public static void main(String[] args) throws ParseException {
        Date timestamp = new SimpleDateFormat("yyyy-MM-dd").parse("2000-11-11");
        System.out.println(new SimpleDateFormat("yyyy年MM月dd日").format(timestamp));
    }
}
