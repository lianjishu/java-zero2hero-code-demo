package io.github.lianjishu.timeclass.jdk8.date.zoneid;

import java.time.ZoneId;
import java.util.Set;

/**
 * ZoneId : 时区
 */
public class ZoneIdDemo {
    /**
     * | 方法名 | 说明 |
     * |---|---|
     * | static Set<String> getAvailableZoneIds() | 获取Java中支持的所有时区 |
     * | static ZoneId systemDefault() | 获取系统默认时区 |
     * | static ZoneId of(String zoneId) | 获取一个指定时区 |
     */
    private static void tasteStatic() {
        // 获取Java中支持的所有时区
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);

        // 获取系统默认时区
        ZoneId zoneId = ZoneId.systemDefault(); // 基础!!
        // 获取一个指定时区
        ZoneId zoneId1 = ZoneId.of("Asia/Taipei");// 基础!!
    }

    public static void main(String[] args) {
        tasteStatic();
    }
}
