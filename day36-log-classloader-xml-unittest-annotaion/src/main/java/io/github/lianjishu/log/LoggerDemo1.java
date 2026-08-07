package io.github.lianjishu.log;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LoggerDemo1 {
    public static final Logger LOGGER = LoggerFactory.getLogger(LoggerDemo1.class);
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH点mm分");
    private static String timeStr = LocalDateTime.now().format(formatter);

    public static void main(String[] args) {
        //登录操作
        //加点记录用户操作的日志
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名: ");
        String username = sc.nextLine();
        System.out.println("请输入密码: ");
        String password = sc.nextLine();

        if("FT".equals(username) && "123".equals(password)) {
            System.out.println("登录成功");
            LOGGER.info("用户于{} 登录 ,用户名为={} 密码为：***", timeStr, username);
        }else {
            System.out.println("登录失败");
            LOGGER.info("用户于{} 登录失败 ,用户名为={}", timeStr, username);
        }
    }
}
