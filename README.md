# Java 零基础到精通 - 代码示例

本项目是跟随[黑马程序员](https://www.itheima.com/)课程学习 Java 过程中的每日代码练习合集，涵盖从基础语法到网络编程的各个阶段。

每学习一天的课程，就把当天的代码写在对应的 Day 目录下，所有代码放在同一个项目中统一管理。

## 环境要求

- JDK 21
- Maven 3.6+

## 项目结构

所有 Java 代码统一位于 `src/main/java/io/github/lianjishu/` 之下。
各 Day 的代码通过子包 / 源码文件名前缀区分(详见各 day 模块下的 pom.xml)。

| 模块 | 简介 |
| --- | --- |
| day01-beginner-level | 入门基础 - HelloWorld |
| day02-basic-concept | 基本概念 - 变量、数据类型、键盘输入 |
| day03-operator | 运算符 - 逻辑运算符、三元运算符 |
| day04-condition-and-loop | 条件判断与循环 - if、switch、for |
| day05-loop-testbook | 循环练习题 |
| day06-method | 方法与数组 |
| day07-comprehensive-exercise | 综合练习 - 数字加密、机票、验证码 |
| day08-oop | 面向对象编程入门 |
| day09-oop-practice | OOP 实战 - 文字格斗游戏 |
| day10-string | 字符串操作 - 模拟登录、罗马数字 |
| day11-oop-plus-arraylist-studentsms | ArrayList 与学生管理系统 |
| day14-oop-plus-comprehensive-exercise | OOP 综合练习 - 动物继承体系 |
| day15-abstract-class-interface-inner-class | 抽象类、接口、内部类、适配器模式 |
| day17-jigsawgame | 拼图游戏 (Swing GUI) |
| day16-event | GUI 事件监听 |
| day18-api-basics-object-clone | API 基础 - Math、Object、Runtime、克隆 |
| day19-api-regular-expression | 正则表达式 |
| day20-api-time-wrapper-class | 时间 API 与包装类 |
| day21-api-algo-lambda | 算法与 Lambda 表达式 (预留) |
| day22-collections-framework-list | 集合框架 - List |
| day33-inet-program | 网络编程 - InetAddress |
| day31-multithreading | 多线程练习 |
| day32-mutithreading-and-juc | JUC 练习 |

## 使用方式

```bash
# 编译整个项目
mvn compile

# 清理构建产物
mvn clean
```

## 注意事项

- 本项目为个人学习用途，代码以演示为主
- 每个 Day 目录相对独立，可单独查看
- Day 编号对应课程天数，部分编号缺失属于正常跳过
- Day21 为预留目录，暂无代码
