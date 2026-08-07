package io.github.lianjishu.timeclass.jdk8.instant;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Instant : 时间戳
 */
public class InstantDemo {
    /**
     * static Instant now() 获取当前时间的Instant对象（标准时间）
     * static Instant ofXxxx(long epochMilli) 根据（秒/毫秒/纳秒）获取Instant对象
     * ZonedDateTime atZone(ZoneId zone) 指定时区
     * boolean isXxx(Instant otherInstant) 判断系列的方法
     * Instant minusXxx(long milliToSubtract) 减少时间系列的方法
     * Instant plusXxx(long milliToSubtract) 增加时间系列的方法
     */
    public static void main(String[] args) {
        // 1.获取当前时间的Instant对象（标准时间）
        System.out.println(Instant.now());
        System.out.println("===================================\n");

        // 2.根据（秒/毫秒/纳秒）获取Instant对象
        Instant milliInstant = Instant.ofEpochMilli(1L); // 从epoch过了1毫秒
        System.out.println(milliInstant);
        System.out.println("===================================\n");
        Instant secInstant = Instant.ofEpochSecond(1L); // 从epoch过了1秒
        System.out.println(secInstant);
        System.out.println("===================================\n");
        Instant secNanoInstant = Instant.ofEpochSecond(1L, 1000000000L); // 从epoch过了1秒+10^9纳秒 = 2秒
        System.out.println(secNanoInstant);
        System.out.println("===================================\n");

        // 3.指定时区 | Instant + Zone = ZonedDateTime
        ZonedDateTime time = Instant.now().atZone(ZoneId.of("Asia/Taipei"));
        System.out.println(time);

        // 4.判断系列的方法
        Instant i1 = Instant.ofEpochMilli(999999L);
        Instant i2 = Instant.now();
        System.out.println(i1.isBefore(i2));
        System.out.println("===================================\n");

        // 5.减少时间系列的方法 | 增加时间系列的方法
        Instant i3 = Instant.ofEpochMilli(30000L);
        System.out.println("i3 = " + i3);
        Instant i4 = i3.minusSeconds(30);
        System.out.println("i4 = " + i4);
        Instant i5 = i4.plusMillis(30000L);
        System.out.println("i5 = " + i5);
        System.out.println("===================================\n");
        
    }
}
